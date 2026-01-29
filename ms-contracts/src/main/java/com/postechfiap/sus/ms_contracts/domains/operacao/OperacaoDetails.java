package com.postechfiap.sus.ms_contracts.domains.operacao;

import com.postechfiap.sus.ms_contracts.domains.enums.StatusOperacao;
import com.postechfiap.sus.ms_contracts.domains.enums.TipoOperacao;

import java.time.LocalDateTime;
import java.util.UUID;

public record OperacaoDetails(
        UUID id,
        TipoOperacao tipo,
        UUID idPaciente,
        UUID idProfissional,
        LocalDateTime dataHora,
        String descricao,
        StatusOperacao status
) {
}
