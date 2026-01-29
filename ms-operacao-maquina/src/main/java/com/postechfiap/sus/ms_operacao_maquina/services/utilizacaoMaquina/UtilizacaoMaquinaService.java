package com.postechfiap.sus.ms_operacao_maquina.services.utilizacaoMaquina;

import com.postechfiap.sus.ms_operacao_maquina.client.MaquinaClientService;
import com.postechfiap.sus.ms_operacao_maquina.client.OperacaoClientService;
import com.postechfiap.sus.ms_operacao_maquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.UtilizacaoMaquinaResponseDto;
import com.postechfiap.sus.ms_operacao_maquina.entities.UtilizacaoMaquinaEntity;
import com.postechfiap.sus.ms_operacao_maquina.exception.RecursoNaoEncontradoException;
import com.postechfiap.sus.ms_operacao_maquina.mappers.UtilizacaoMaquinaMapper;
import com.postechfiap.sus.ms_operacao_maquina.repositories.UtilizacaoMaquinaRepository;
import org.springframework.stereotype.Service;

@Service
public class UtilizacaoMaquinaService implements IUtilizacaoMaquinaService {

    private final UtilizacaoMaquinaRepository utilizacaoMaquinaRepository;
    private final UtilizacaoMaquinaMapper utilizacaoMaquinaMapper;
    private final MaquinaClientService maquinaClientService;
    private final OperacaoClientService operacaoClientService;

    public UtilizacaoMaquinaService(UtilizacaoMaquinaRepository utilizacaoMaquinaRepository, UtilizacaoMaquinaMapper utilizacaoMaquinaMapper, MaquinaClientService maquinaClientService, OperacaoClientService operacaoClientService) {
        this.utilizacaoMaquinaRepository = utilizacaoMaquinaRepository;
        this.utilizacaoMaquinaMapper = utilizacaoMaquinaMapper;
        this.maquinaClientService = maquinaClientService;
        this.operacaoClientService = operacaoClientService;
    }

    @Override
    public UtilizacaoMaquinaResponseDto criarUtilizacaoMaquina(UtilizacaoMaquinaRequestDto dto) {

        // Verifica se a máquina existe no microserviço ms-maquina
        try{
            maquinaClientService.buscarMaquinaPorId(dto.idMaquina());
            operacaoClientService.buscarOperacaoPorId(dto.idOperacao());
            UtilizacaoMaquinaEntity utilizacaoMaquinaEntity = utilizacaoMaquinaRepository.save(utilizacaoMaquinaMapper.toEntity(dto));
            return utilizacaoMaquinaMapper.toDto(utilizacaoMaquinaEntity);
        }catch (RecursoNaoEncontradoException e){
            throw new RecursoNaoEncontradoException("Máquina não encontrada com o ID: " + dto.idMaquina());
        }catch (RuntimeException e){
            throw new RuntimeException("Ocorreu um erro inesperado, favor tente novamente");
        }

    }

}
