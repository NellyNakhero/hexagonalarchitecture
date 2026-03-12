package com.learning.hexagonalarchitecture.application.port.inbound.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class UpdateGraffitiCommand {
    private UUID id;
    private String name;
    private String description;
    private String location;
    private String[] painters;
    private Boolean forSale;
    private Map<String, String> attributes;
}
