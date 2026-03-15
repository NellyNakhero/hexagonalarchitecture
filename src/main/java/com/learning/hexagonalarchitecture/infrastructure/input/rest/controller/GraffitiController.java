package com.learning.hexagonalarchitecture.infrastructure.input.rest.controller;

import com.learning.hexagonalarchitecture.application.port.inbound.GraffitiManagementUseCase;
import com.learning.hexagonalarchitecture.application.port.inbound.command.CreateGraffitiCommand;
import com.learning.hexagonalarchitecture.application.port.inbound.command.UpdateGraffitiCommand;
import com.learning.hexagonalarchitecture.application.port.inbound.response.GraffitiResponse;
import com.learning.hexagonalarchitecture.infrastructure.input.rest.request.UpdateGraffitiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/graffiti/")
@RequiredArgsConstructor
public class GraffitiController {
    private final GraffitiManagementUseCase graffitiManagement;

    @PostMapping
    ResponseEntity<GraffitiResponse> createGraffiti(@RequestBody UpdateGraffitiRequest createGraffitiRequest) {
        CreateGraffitiCommand command = new CreateGraffitiCommand(
                createGraffitiRequest.getName(),
                createGraffitiRequest.getDescription(),
                createGraffitiRequest.getLocation(),
                createGraffitiRequest.getPainters(),
                createGraffitiRequest.getForSale(),
                createGraffitiRequest.getAttributes());

        GraffitiResponse response = graffitiManagement.createGraffiti(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("{id}")
    ResponseEntity<GraffitiResponse> readGraffiti(@PathVariable UUID id) {
        GraffitiResponse response = graffitiManagement.findGraffitiById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    ResponseEntity<List<GraffitiResponse>> readAllGraffiti() {
        List<GraffitiResponse> response = graffitiManagement.findAllGraffiti();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    ResponseEntity<GraffitiResponse> updateGraffiti(@RequestBody UpdateGraffitiRequest updateGraffitiRequest) {
        UpdateGraffitiCommand command = new UpdateGraffitiCommand(
                updateGraffitiRequest.getId(),
                updateGraffitiRequest.getName(),
                updateGraffitiRequest.getDescription(),
                updateGraffitiRequest.getLocation(),
                updateGraffitiRequest.getPainters(),
                updateGraffitiRequest.getForSale(),
                updateGraffitiRequest.getAttributes());

        GraffitiResponse response = graffitiManagement.updateGraffiti(command);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("{id}")
    ResponseEntity<GraffitiResponse> deleteGraffiti(@PathVariable UUID id) {
        graffitiManagement.deleteGraffiti(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/enlist-for-sale")
    ResponseEntity<GraffitiResponse> enlistForSale(@PathVariable UUID id) {
        GraffitiResponse response = graffitiManagement.markGraffitiAsOnSale(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PatchMapping("/{id}/delist-for-sale")
    ResponseEntity<GraffitiResponse> delistForSale(@PathVariable UUID id) {
        GraffitiResponse response = graffitiManagement.markGraffitiAsNotOnSale(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
