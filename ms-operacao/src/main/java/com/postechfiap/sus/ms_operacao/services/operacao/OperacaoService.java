package com.postechfiap.sus.ms_operacao.services.operacao;

import com.postechfiap.sus.ms_contracts.domains.operacao.OperacaoDetails;
import com.postechfiap.sus.ms_operacao.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.ms_operacao.dto.response.OperacaoResponseDetalhesDto;
import com.postechfiap.sus.ms_operacao.entities.OperacaoEntity;
import com.postechfiap.sus.ms_operacao.exception.RecursoNaoEncontradoException;
import com.postechfiap.sus.ms_operacao.mappers.OperacaoMapper;
import com.postechfiap.sus.ms_operacao.repositories.OperacaoRepository;
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
    public OperacaoResponseDetalhesDto criarOperacao(OperacaoRequestDto request) { //, Authentication authentication

        OperacaoEntity operacaoEntity = operacaoRepository.save(operacaoMapper.toEntity(request));

//            avaliacaoProducer.sendAvaliacaoEvent(event);
        //}

        return operacaoMapper.toDtoDetalhes(operacaoEntity);
    }

    @Override
    public OperacaoDetails buscarOperacaoPorId(UUID id) {
        return operacaoMapper.toDto(operacaoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Operação não encontrada com o ID: " + id)));
    }

    @Override
    public OperacaoResponseDetalhesDto buscarOperacaoPorIdDetalhes(UUID id) {
        return operacaoMapper.toDtoDetalhes(operacaoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Operação não encontrada com o ID: " + id)));
    }

    @Override
    public List<OperacaoResponseDetalhesDto> buscarOperacoes() {
        try{
            return operacaoRepository.findAll().stream().map(operacaoMapper::toDtoDetalhes).toList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Houve um erro na busca das operações.");
        }
    }

}
