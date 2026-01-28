package com.postechfiap.sus.msmaquina.services.maquina;

import com.postechfiap.sus.ms_contracts.domains.maquina.MaquinaDetails;
import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDtoDetalhes;
import com.postechfiap.sus.msmaquina.entities.MaquinaEntity;
import com.postechfiap.sus.msmaquina.exception.RecursoNaoEncontradoException;
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
    public MaquinaResponseDtoDetalhes criarMaquina(MaquinaRequestDto request) { //, Authentication authentication

        MaquinaEntity maquinaEntity = maquinaRepository.save(maquinaMapper.toEntity(request));

//            avaliacaoProducer.sendAvaliacaoEvent(event);
        //}

        return maquinaMapper.toDtoDetalhes(maquinaEntity);
    }

    @Override
    public MaquinaResponseDtoDetalhes buscarMaquinaPorIdDetalhes(UUID id) {
        MaquinaEntity avaliacaoEntity = maquinaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Máquina não encontrada com o ID: " + id));
        return maquinaMapper.toDtoDetalhes(avaliacaoEntity);
    }

    @Override
    public MaquinaDetails buscarMaquinaPorId(UUID id) {
        MaquinaEntity avaliacaoEntity = maquinaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Máquina não encontrada com o ID: " + id));
        return maquinaMapper.toDto(avaliacaoEntity);
    }


}
