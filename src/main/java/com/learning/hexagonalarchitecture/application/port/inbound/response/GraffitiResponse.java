package com.learning.hexagonalarchitecture.application.port.inbound.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GraffitiResponse {
    private UUID id;
    private String name;
    private String description;
    private String location;
    private List<String> painters;
    private Boolean forSale;
    private Map<String, String> attributes;
}
