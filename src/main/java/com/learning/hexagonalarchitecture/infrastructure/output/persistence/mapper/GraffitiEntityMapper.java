package com.learning.hexagonalarchitecture.infrastructure.output.persistence.mapper;

import com.learning.hexagonalarchitecture.domain.model.Graffiti;
import com.learning.hexagonalarchitecture.infrastructure.output.persistence.entity.GraffitiEntity;
import org.springframework.stereotype.Component;

@Component
public class GraffitiEntityMapper {
    public Graffiti toDomain(GraffitiEntity entity) {
        return Graffiti.createGraffiti(entity.getName(),
                entity.getDescription(),
                entity.getLocation(),
                entity.getPainters(),
                entity.getForSale(),
                entity.getAttributes());
    }

    public GraffitiEntity toEntity(Graffiti graffiti) {
        return new GraffitiEntity(
                graffiti.getId(),graffiti.getName(),
                graffiti.getDescription(),
                graffiti.getLocation(),
                graffiti.getPainters(),
                graffiti.getForSale(),
                graffiti.getAttributes());
    }
}
