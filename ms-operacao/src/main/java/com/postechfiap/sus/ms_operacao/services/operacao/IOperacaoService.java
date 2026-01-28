package com.postechfiap.sus.ms_operacao.services.operacao;

import com.postechfiap.sus.ms_operacao.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.ms_operacao.dto.response.OperacaoResponseDto;

public interface IOperacaoService {
    OperacaoResponseDto criarOperacao(OperacaoRequestDto dto);
}
