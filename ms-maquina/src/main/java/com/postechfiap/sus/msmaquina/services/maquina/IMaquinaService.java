package com.postechfiap.sus.msmaquina.services.maquina;

import com.postechfiap.sus.ms_contracts.domains.maquina.MaquinaDetails;
import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDtoDetalhes;

import java.util.UUID;

public interface IMaquinaService {

    MaquinaResponseDtoDetalhes criarMaquina(MaquinaRequestDto dto);
    MaquinaResponseDtoDetalhes buscarMaquinaPorIdDetalhes(UUID id);
    MaquinaDetails buscarMaquinaPorId(UUID id);
}
