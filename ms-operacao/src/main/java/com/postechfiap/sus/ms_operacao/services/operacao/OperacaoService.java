package com.postechfiap.sus.ms_operacao.services.operacao;

import com.postechfiap.sus.ms_operacao.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.ms_operacao.dto.response.OperacaoResponseDto;
import com.postechfiap.sus.ms_operacao.entities.OperacaoEntity;
import com.postechfiap.sus.ms_operacao.mappers.OperacaoMapper;
import com.postechfiap.sus.ms_operacao.repositories.OperacaoRepository;
import org.springframework.stereotype.Service;

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
