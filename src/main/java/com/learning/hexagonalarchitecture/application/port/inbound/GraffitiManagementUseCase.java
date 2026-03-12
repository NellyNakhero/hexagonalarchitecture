package com.learning.hexagonalarchitecture.application.port.inbound;

import com.learning.hexagonalarchitecture.application.port.inbound.command.CreateGraffitiCommand;
import com.learning.hexagonalarchitecture.application.port.inbound.command.UpdateGraffitiCommand;
import com.learning.hexagonalarchitecture.application.port.inbound.response.GraffitiResponse;

import java.util.List;
import java.util.UUID;

public interface GraffitiManagementUseCase {
    GraffitiResponse createGraffiti(CreateGraffitiCommand command);
    GraffitiResponse findGraffitiById(UUID id);
    List<GraffitiResponse> findAllGraffiti();
    GraffitiResponse updateGraffiti(UpdateGraffitiCommand command);
    void deleteGraffiti(UUID id);
    void deleteAllGraffiti();
    GraffitiResponse findGraffitiByName(String name);
    GraffitiResponse markGraffitiAsOnSale(UUID id);
    GraffitiResponse markGraffitiAsNotOnSale(UUID id);
}
