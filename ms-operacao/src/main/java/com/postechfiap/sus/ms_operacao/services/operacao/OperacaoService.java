package com.postechfiap.sus.ms_operacao.services.operacao;

import com.postechfiap.sus.ms_operacao.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.ms_operacao.dto.response.OperacaoResponseDto;
import com.postechfiap.sus.ms_operacao.entities.OperacaoEntity;
import com.postechfiap.sus.ms_operacao.exception.RecursoNaoEncontradoException;
import com.postechfiap.sus.ms_operacao.mappers.OperacaoMapper;
import com.postechfiap.sus.ms_operacao.repositories.OperacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public OperacaoResponseDto buscarOperacaoPorId(UUID id) {
        return operacaoMapper.toDto(operacaoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Operação não encontrada com o ID: " + id)));
    }

    @Override
    public List<OperacaoResponseDto> buscarOperacoes() {
        try{
            return operacaoRepository.findAll().stream().map(operacaoMapper::toDto).toList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Houve um erro na busca das operações.");
        }
    }

}
