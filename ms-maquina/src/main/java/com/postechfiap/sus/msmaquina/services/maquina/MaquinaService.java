package com.postechfiap.sus.msmaquina.services.maquina;

import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.entities.MaquinaEntity;
import com.postechfiap.sus.msmaquina.entities.UtilizacaoMaquinaEntity;
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

    @Override
    public MaquinaResponseDto criarMaquina(MaquinaRequestDto request) { //, Authentication authentication

        MaquinaEntity maquinaEntity = maquinaRepository.save(maquinaMapper.toEntity(request));

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
