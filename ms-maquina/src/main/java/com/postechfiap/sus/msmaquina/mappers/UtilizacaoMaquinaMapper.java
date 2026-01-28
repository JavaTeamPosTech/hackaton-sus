package com.postechfiap.sus.msmaquina.mappers;

import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.dto.response.UtilizacaoMaquinaResponseDto;
import com.postechfiap.sus.msmaquina.entities.MaquinaEntity;
import com.postechfiap.sus.msmaquina.entities.UtilizacaoMaquinaEntity;
import com.postechfiap.sus.msmaquina.entities.enums.StatusMaquina;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UtilizacaoMaquinaMapper {

    public UtilizacaoMaquinaEntity toEntity(UtilizacaoMaquinaRequestDto dto){
        UtilizacaoMaquinaEntity entity = new UtilizacaoMaquinaEntity();
        entity.setIdMaquina(dto.idMaquina());
        entity.setIdOperacao(dto.idOperacao());
        entity.setDataUtilizacao(LocalDateTime.now());
        return entity;
    }

    public UtilizacaoMaquinaResponseDto toDto(UtilizacaoMaquinaEntity entity){
        return new UtilizacaoMaquinaResponseDto(
            entity.getId(),
            entity.getIdMaquina(),
            entity.getIdOperacao(),
            entity.getDataUtilizacao());
    }

}
