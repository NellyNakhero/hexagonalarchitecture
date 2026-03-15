package com.learning.hexagonalarchitecture.application.port.inbound.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class CreateGraffitiCommand {
    private final String name;
    private final String description;
    private final String location;
    private final List<String> painters;
    private final Boolean forSale;
    private final Map<String, String> attributes;
}
