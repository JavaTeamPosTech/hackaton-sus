package com.postechfiap.sus.msmaquina.services.utilizacaoMaquina;

import com.postechfiap.sus.msmaquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.dto.response.UtilizacaoMaquinaResponseDto;
import com.postechfiap.sus.msmaquina.entities.UtilizacaoMaquinaEntity;
import com.postechfiap.sus.msmaquina.mappers.MaquinaMapper;
import com.postechfiap.sus.msmaquina.mappers.UtilizacaoMaquinaMapper;
import com.postechfiap.sus.msmaquina.repositories.MaquinaRepository;
import com.postechfiap.sus.msmaquina.repositories.UtilizacaoMaquinaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
