package com.postechfiap.sus.msmaquina.services.maquina;

import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDto;

import java.util.UUID;

public interface IMaquinaService {

    MaquinaResponseDto criarMaquina(MaquinaRequestDto dto);
    MaquinaResponseDto buscarMaquinaPorId(UUID id);
}
