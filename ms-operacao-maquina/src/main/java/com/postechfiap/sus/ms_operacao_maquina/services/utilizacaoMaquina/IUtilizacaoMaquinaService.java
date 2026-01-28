package com.postechfiap.sus.ms_operacao_maquina.services.utilizacaoMaquina;

import com.postechfiap.sus.ms_operacao_maquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.UtilizacaoMaquinaResponseDto;

public interface IUtilizacaoMaquinaService {

    UtilizacaoMaquinaResponseDto criarUtilizacaoMaquina(UtilizacaoMaquinaRequestDto dto);
}
