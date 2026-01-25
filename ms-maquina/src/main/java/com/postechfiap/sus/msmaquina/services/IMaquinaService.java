package com.postechfiap.sus.msmaquina.services;

import com.postechfiap.sus.msmaquina.dto.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.MaquinaResponseDto;

import java.util.UUID;

public interface IMaquinaService {

    MaquinaResponseDto criarMaquina(MaquinaRequestDto dto);
    MaquinaResponseDto buscarMaquinaPorId(UUID id);
}
