package com.postechfiap.sus.msmaquina.services.operacao;

import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.dto.response.OperacaoResponseDto;
import com.postechfiap.sus.msmaquina.entities.MaquinaEntity;
import com.postechfiap.sus.msmaquina.entities.OperacaoEntity;
import com.postechfiap.sus.msmaquina.mappers.MaquinaMapper;
import com.postechfiap.sus.msmaquina.mappers.OperacaoMapper;
import com.postechfiap.sus.msmaquina.repositories.MaquinaRepository;
import com.postechfiap.sus.msmaquina.repositories.OperacaoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OperacaoService implements IOperacaoService {

    private final OperacaoRepository operacaoRepository;
    private final OperacaoMapper operacaoMapper;

    public OperacaoService(OperacaoRepository operacaoRepository, OperacaoMapper operacaoMapper) {
        this.operacaoRepository = operacaoRepository;
        this.operacaoMapper = operacaoMapper;
    }

    @Override
    public OperacaoResponseDto criarOperacao(OperacaoRequestDto request) { //, Authentication authentication

        OperacaoEntity operacaoEntity = operacaoRepository.save(operacaoMapper.toEntity(request));

//            avaliacaoProducer.sendAvaliacaoEvent(event);
        //}

        return operacaoMapper.toDto(operacaoEntity);
    }

}
