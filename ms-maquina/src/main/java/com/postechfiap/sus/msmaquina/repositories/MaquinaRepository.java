package com.postechfiap.sus.msmaquina.repositories;

import com.postechfiap.sus.msmaquina.entities.MaquinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MaquinaRepository extends JpaRepository<MaquinaEntity, UUID> {
}
