package com.postechfiap.sus.msmaquina.services;

import com.postechfiap.sus.msmaquina.dto.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.entities.MaquinaEntity;
import com.postechfiap.sus.msmaquina.mappers.MaquinaMapper;
import com.postechfiap.sus.msmaquina.repositories.MaquinaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MaquinaService implements IMaquinaService {

    private final MaquinaRepository maquinaRepository;
    private final MaquinaMapper maquinaMapper;

    public MaquinaService(MaquinaRepository maquinaRepository, MaquinaMapper maquinaMapper) {
        this.maquinaRepository = maquinaRepository;
        this.maquinaMapper = maquinaMapper;
    }

    public MaquinaResponseDto criarMaquina(MaquinaRequestDto request) { //, Authentication authentication

        MaquinaEntity maquinaEntity;

        maquinaEntity = maquinaRepository.save(maquinaMapper.toEntity(request));

//            avaliacaoProducer.sendAvaliacaoEvent(event);
        //}

        return maquinaMapper.toDto(maquinaEntity);
    }

    @Override
    public MaquinaResponseDto buscarMaquinaPorId(UUID id) {
        MaquinaEntity avaliacaoEntity = maquinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Máquina não encontrada com o ID: " + id));
        return maquinaMapper.toDto(avaliacaoEntity);
    }

}
