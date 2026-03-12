package com.learning.hexagonalarchitecture.application.port.outbound;

import com.learning.hexagonalarchitecture.domain.model.Graffiti;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GrafitiRepository {
    Optional<Graffiti> findById(UUID id);
    Optional<Graffiti> findByName(String name);
    List<Graffiti> findAll();
    Graffiti save(Graffiti graffiti);
    void deleteById(UUID id);
    void deleteAllGraffiti();
}
