package com.postechfiap.sus.ms_operacao.services.operacao;

import com.postechfiap.sus.ms_contracts.domains.operacao.OperacaoDetails;
import com.postechfiap.sus.ms_operacao.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.ms_operacao.dto.response.OperacaoResponseDetalhesDto;

import java.util.List;
import java.util.UUID;

public interface IOperacaoService {
    OperacaoResponseDetalhesDto criarOperacao(OperacaoRequestDto dto);
    OperacaoResponseDetalhesDto buscarOperacaoPorIdDetalhes(UUID id);
    OperacaoDetails buscarOperacaoPorId(UUID id);
    List<OperacaoResponseDetalhesDto> buscarOperacoes();
}
