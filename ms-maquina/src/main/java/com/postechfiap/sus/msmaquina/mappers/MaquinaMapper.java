package com.postechfiap.sus.msmaquina.mappers;

import com.postechfiap.sus.ms_contracts.domains.maquina.MaquinaDetails;
import com.postechfiap.sus.msmaquina.dto.request.MaquinaRequestDto;
import com.postechfiap.sus.msmaquina.dto.response.MaquinaResponseDtoDetalhes;
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

    public MaquinaResponseDtoDetalhes toDtoDetalhes(MaquinaEntity entity){
        return new MaquinaResponseDtoDetalhes(
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

    public MaquinaDetails toDto(MaquinaEntity entity){
        return new MaquinaDetails(
                entity.getId(),
                entity.getModelo(),
                entity.getFabricante(),
                entity.getNumeroSerie(),
                entity.getLocalizacao(),
                entity.getCodigoPatrimonio(),
                com.postechfiap.sus.ms_contracts.domains.enums.TipoMaquina
                        .valueOf(entity.getTipo().name()),
                com.postechfiap.sus.ms_contracts.domains.enums.StatusMaquina
                        .valueOf(entity.getStatus().name()),
                entity.getDataCadastro()
        );
    }

}
