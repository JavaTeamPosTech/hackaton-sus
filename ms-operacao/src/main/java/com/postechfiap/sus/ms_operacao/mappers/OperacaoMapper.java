package com.postechfiap.sus.ms_operacao.mappers;

import com.postechfiap.sus.ms_contracts.domains.operacao.OperacaoDetails;
import com.postechfiap.sus.ms_operacao.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.ms_operacao.dto.response.OperacaoResponseDetalhesDto;
import com.postechfiap.sus.ms_operacao.entities.OperacaoEntity;
import org.springframework.stereotype.Service;

@Service
public class OperacaoMapper {

    public OperacaoEntity toEntity(OperacaoRequestDto dto){
        OperacaoEntity entity = new OperacaoEntity();
        entity.setTipo(dto.tipo());
        entity.setIdPaciente(dto.idPaciente());
        entity.setIdProfissional(dto.idProfissional());
        entity.setDataHora(dto.dataHora());
        entity.setDescricao(dto.descricao());
        entity.setStatus(dto.status());
        return entity;
    }

    public OperacaoResponseDetalhesDto toDtoDetalhes(OperacaoEntity entity){
        return new OperacaoResponseDetalhesDto(
            entity.getId(),
            entity.getTipo(),
            entity.getIdPaciente(),
            entity.getIdProfissional(),
            entity.getDataHora(),
            entity.getDescricao(),
            entity.getStatus()
        );
    }

    public OperacaoDetails toDto(OperacaoEntity entity){
        return new OperacaoDetails(
                entity.getId(),
                com.postechfiap.sus.ms_contracts.domains.enums.TipoOperacao
                        .valueOf(entity.getTipo().name()),
                entity.getIdPaciente(),
                entity.getIdProfissional(),
                entity.getDataHora(),
                entity.getDescricao(),
                com.postechfiap.sus.ms_contracts.domains.enums.StatusOperacao
                        .valueOf(entity.getStatus().name())
        );
    }


}
