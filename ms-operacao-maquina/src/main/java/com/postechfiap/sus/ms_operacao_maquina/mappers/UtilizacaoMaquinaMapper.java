package com.postechfiap.sus.ms_operacao_maquina.mappers;

import com.postechfiap.sus.ms_operacao_maquina.dto.request.UtilizacaoMaquinaRequestDto;
import com.postechfiap.sus.ms_operacao_maquina.dto.response.UtilizacaoMaquinaResponseDto;
import com.postechfiap.sus.ms_operacao_maquina.entities.UtilizacaoMaquinaEntity;
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
