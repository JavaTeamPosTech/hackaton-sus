package com.postechfiap.sus.msmaquina.services.operacao;

import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.dto.response.OperacaoResponseDto;

import java.util.UUID;

public interface IOperacaoService {
    OperacaoResponseDto criarOperacao(OperacaoRequestDto dto);
}
