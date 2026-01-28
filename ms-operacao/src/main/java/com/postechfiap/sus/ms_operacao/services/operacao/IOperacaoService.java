package com.postechfiap.sus.ms_operacao.services.operacao;

import com.postechfiap.sus.ms_operacao.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.ms_operacao.dto.response.OperacaoResponseDto;

import java.util.UUID;

public interface IOperacaoService {
    OperacaoResponseDto criarOperacao(OperacaoRequestDto dto);
    OperacaoResponseDto buscarOperacaoPorId(UUID id);
}
