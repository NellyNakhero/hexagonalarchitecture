package com.learning.hexagonalarchitecture.application.service;

import com.learning.hexagonalarchitecture.application.port.inbound.response.GraffitiResponse;
import com.learning.hexagonalarchitecture.domain.model.Graffiti;
import org.springframework.stereotype.Component;

@Component
public class GrafittiMapper {
    public GraffitiResponse toResponse(Graffiti graffiti) {
        return GraffitiResponse.builder()
                .id(graffiti.getId())
                .name(graffiti.getName())
                .description(graffiti.getDescription())
                .location(graffiti.getLocation())
                .painters(graffiti.getPainters().stream().toList())
                .forSale(graffiti.getForSale())
                .attributes(graffiti.getAttributes())
                .build();
    }
}
