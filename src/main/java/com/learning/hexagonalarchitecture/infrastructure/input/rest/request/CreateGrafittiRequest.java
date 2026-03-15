package com.learning.hexagonalarchitecture.infrastructure.input.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateGrafittiRequest {
    @NotBlank(message = "Graffiti name is required")
    private String name;

    @NotBlank(message = "Graffiti name is required")
    private String description;
    private String location;
    private String[] painters;
    @NotNull(message = "The graffiti needs to be specified if its for sale")
    private Boolean forSale;
    private Map<String, String> attributes;
}
