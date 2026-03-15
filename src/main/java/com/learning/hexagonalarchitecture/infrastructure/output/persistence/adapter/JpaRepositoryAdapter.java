package com.learning.hexagonalarchitecture.infrastructure.output.persistence.adapter;

import com.learning.hexagonalarchitecture.application.port.outbound.GrafitiRepository;
import com.learning.hexagonalarchitecture.application.service.GrafittiMapper;
import com.learning.hexagonalarchitecture.domain.model.Graffiti;
import com.learning.hexagonalarchitecture.infrastructure.output.persistence.entity.GraffitiEntity;
import com.learning.hexagonalarchitecture.infrastructure.output.persistence.mapper.GraffitiEntityMapper;
import com.learning.hexagonalarchitecture.infrastructure.output.persistence.repository.SpringDataGraffitiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class JpaRepositoryAdapter implements GrafitiRepository {
    private final SpringDataGraffitiRepository repository;
    private final GraffitiEntityMapper mapper;

    @Override
    public Optional<Graffiti> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Graffiti> findByName(String name) {
        return  repository.findByName(name).map(mapper::toDomain);
    }

    @Override
    public List<Graffiti> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Graffiti save(Graffiti graffiti) {
        var entity = mapper.toEntity(graffiti);
        var savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllGraffiti() {
        repository.deleteAll();
    }
}
