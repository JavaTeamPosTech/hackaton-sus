package com.postechfiap.sus.msmaquina.mappers;

import com.postechfiap.sus.msmaquina.dto.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.MaquinaResponseDto;
import com.postechfiap.sus.msmaquina.entities.MaquinaEntity;
import com.postechfiap.sus.msmaquina.entities.enums.StatusMaquina;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MaquinaMapper {

    public MaquinaEntity toEntity(MaquinaRequestDto dto){
        MaquinaEntity entity = new MaquinaEntity();
        entity.setModelo(dto.modelo());
        entity.setFabricante(dto.fabricante());
        entity.setNumeroSerie(dto.numeroSerie());
        entity.setLocalizacao(dto.localizacao());
        entity.setCodigoPatrimonio(dto.codigoPatrimonio());
        entity.setTipo(dto.tipo());
        entity.setStatus(StatusMaquina.ATIVA);
        entity.setDataCadastro(LocalDateTime.now());
        return entity;
    }

    public MaquinaResponseDto toDto(MaquinaEntity entity){
        return new MaquinaResponseDto(
            entity.getId(),
            entity.getModelo(),
            entity.getFabricante(),
            entity.getNumeroSerie(),
            entity.getLocalizacao(),
            entity.getCodigoPatrimonio(),
            entity.getTipo(),
            entity.getStatus(),
            entity.getDataCadastro()
        );
    }

}
