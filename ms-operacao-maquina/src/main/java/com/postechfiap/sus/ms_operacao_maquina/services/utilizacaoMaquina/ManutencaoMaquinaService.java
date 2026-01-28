package com.postechfiap.sus.ms_operacao_maquina.services.utilizacaoMaquina;

import com.postechfiap.sus.ms_operacao_maquina.client.MaquinaClientService;
import com.postechfiap.sus.ms_operacao_maquina.dto.request.ManutencaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.ManutencaoMaquinaResponseDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.UtilizacaoMaquinaResponseDto;
import com.postechfiap.sus.ms_operacao_maquina.entities.ManutencaoMaquinaEntity;
import com.postechfiap.sus.ms_operacao_maquina.entities.UtilizacaoMaquinaEntity;
import com.postechfiap.sus.ms_operacao_maquina.exception.RecursoNaoEncontradoException;
import com.postechfiap.sus.ms_operacao_maquina.mappers.ManutencaoMaquinaMapper;
import com.postechfiap.sus.ms_operacao_maquina.mappers.UtilizacaoMaquinaMapper;
import com.postechfiap.sus.ms_operacao_maquina.repositories.ManutencaoMaquinaRepository;
import com.postechfiap.sus.ms_operacao_maquina.repositories.UtilizacaoMaquinaRepository;
import org.springframework.stereotype.Service;

@Service
public class ManutencaoMaquinaService implements IManutencaoMaquinaService {

    private final ManutencaoMaquinaRepository manutencaoMaquinaRepository;
    private final ManutencaoMaquinaMapper manutencaoMaquinaMapper;
    private final MaquinaClientService maquinaClientService;

    public ManutencaoMaquinaService(ManutencaoMaquinaRepository manutencaoMaquinaRepository, ManutencaoMaquinaMapper manutencaoMaquinaMapper, MaquinaClientService maquinaClientService) {
        this.manutencaoMaquinaRepository = manutencaoMaquinaRepository;
        this.manutencaoMaquinaMapper = manutencaoMaquinaMapper;
        this.maquinaClientService = maquinaClientService;
    }

    @Override
    public ManutencaoMaquinaResponseDto criarManutencaoMaquina(ManutencaoMaquinaRequestDto dto) {
        try{
            maquinaClientService.buscarMaquinaPorId(dto.idMaquina());
            ManutencaoMaquinaEntity manutencaoMaquinaEntity = manutencaoMaquinaRepository.save(manutencaoMaquinaMapper.toEntity(dto));
            return manutencaoMaquinaMapper.toDto(manutencaoMaquinaEntity);
        }catch (RecursoNaoEncontradoException e){
            throw new RecursoNaoEncontradoException("Máquina não encontrada com o ID: " + dto.idMaquina());
        }

    }

}
