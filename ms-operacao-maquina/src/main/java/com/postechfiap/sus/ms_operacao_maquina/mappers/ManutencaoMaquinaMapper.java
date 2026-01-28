package com.postechfiap.sus.ms_operacao_maquina.mappers;

import com.postechfiap.sus.ms_operacao_maquina.dto.request.ManutencaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.ManutencaoMaquinaResponseDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.UtilizacaoMaquinaResponseDto;
import com.postechfiap.sus.ms_operacao_maquina.entities.ManutencaoMaquinaEntity;
import com.postechfiap.sus.ms_operacao_maquina.entities.UtilizacaoMaquinaEntity;
import com.postechfiap.sus.ms_operacao_maquina.entities.enums.StatusManutencao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ManutencaoMaquinaMapper {

    public ManutencaoMaquinaEntity toEntity(ManutencaoMaquinaRequestDto dto) {

        ManutencaoMaquinaEntity entity = new ManutencaoMaquinaEntity();

        entity.setIdMaquina(dto.idMaquina());
        entity.setTipo(dto.tipo());
        entity.setStatus(StatusManutencao.AGENDADA); // regra de negócio
        entity.setDataInicio(dto.dataInicio());
        entity.setDescricao(dto.descricao());
        entity.setMaquinaIndisponivel(dto.maquinaIndisponivel());
        entity.setCustoManutencao(dto.custoManutencao());

        return entity;
    }

    public ManutencaoMaquinaResponseDto toDto(ManutencaoMaquinaEntity entity) {

        return new ManutencaoMaquinaResponseDto(
                entity.getId(),
                entity.getIdMaquina(),
                entity.getTipo(),
                entity.getStatus(),
                entity.getDataInicio(),
                entity.getDataFim(),
                entity.getDescricao(),
                entity.getObservacoes(),
                entity.isMaquinaIndisponivel(),
                entity.getCustoManutencao()
        );
    }
}
