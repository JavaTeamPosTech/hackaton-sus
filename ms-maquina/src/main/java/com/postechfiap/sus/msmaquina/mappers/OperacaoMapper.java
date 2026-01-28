package com.postechfiap.sus.msmaquina.mappers;

import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.OperacaoRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.dto.response.OperacaoResponseDto;
import com.postechfiap.sus.msmaquina.entities.MaquinaEntity;
import com.postechfiap.sus.msmaquina.entities.OperacaoEntity;
import com.postechfiap.sus.msmaquina.entities.enums.StatusMaquina;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    public OperacaoResponseDto toDto(OperacaoEntity entity){
        return new OperacaoResponseDto(
            entity.getId(),
            entity.getTipo(),
            entity.getIdPaciente(),
            entity.getIdProfissional(),
            entity.getDataHora(),
            entity.getDescricao(),
            entity.getStatus()
        );
    }

}
