package com.postechfiap.sus.ms_operacao_maquina.services.utilizacaoMaquina;

import com.postechfiap.sus.ms_operacao_maquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.UtilizacaoMaquinaResponseDto;
import com.postechfiap.sus.ms_operacao_maquina.entities.UtilizacaoMaquinaEntity;
import com.postechfiap.sus.ms_operacao_maquina.mappers.UtilizacaoMaquinaMapper;
import com.postechfiap.sus.ms_operacao_maquina.repositories.UtilizacaoMaquinaRepository;
import org.springframework.stereotype.Service;

@Service
public class UtilizacaoMaquinaService implements IUtilizacaoMaquinaService {

    private final UtilizacaoMaquinaRepository utilizacaoMaquinaRepository;
    private final UtilizacaoMaquinaMapper utilizacaoMaquinaMapper;

    public UtilizacaoMaquinaService(UtilizacaoMaquinaRepository utilizacaoMaquinaRepository, UtilizacaoMaquinaMapper utilizacaoMaquinaMapper) {
        this.utilizacaoMaquinaRepository = utilizacaoMaquinaRepository;
        this.utilizacaoMaquinaMapper = utilizacaoMaquinaMapper;
    }

    @Override
    public UtilizacaoMaquinaResponseDto criarUtilizacaoMaquina(UtilizacaoMaquinaRequestDto dto) {
        UtilizacaoMaquinaEntity utilizacaoMaquinaEntity = utilizacaoMaquinaRepository.save(utilizacaoMaquinaMapper.toEntity(dto));
        return utilizacaoMaquinaMapper.toDto(utilizacaoMaquinaEntity);
    }

}
