package com.learning.hexagonalarchitecture.infrastructure.output.persistence.repository;

import com.learning.hexagonalarchitecture.infrastructure.output.persistence.entity.GraffitiEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataGraffitiRepository extends CrudRepository<GraffitiEntity, UUID> {
    Optional<GraffitiEntity> findByName(String name);
}
