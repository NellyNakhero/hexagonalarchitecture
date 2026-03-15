package com.learning.hexagonalarchitecture.infrastructure.input.rest.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateGraffitiRequest {
    @NotNull(message = "graffiti id is required")
    private UUID id;
    private String name;
    private String description;
    private String location;
    private List<String> painters;
    private Boolean forSale;
    private Map<String, String> attributes;
}
