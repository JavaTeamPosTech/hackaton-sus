package com.postechfiap.sus.msmaquina.services.utilizacaoMaquina;

import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.dto.response.UtilizacaoMaquinaResponseDto;

import java.util.UUID;

public interface IUtilizacaoMaquinaService {

    UtilizacaoMaquinaResponseDto criarUtilizacaoMaquina(UtilizacaoMaquinaRequestDto dto);
}
