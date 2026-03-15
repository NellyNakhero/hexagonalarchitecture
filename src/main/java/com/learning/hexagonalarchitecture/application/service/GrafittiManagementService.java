package com.learning.hexagonalarchitecture.application.service;

import com.learning.hexagonalarchitecture.application.port.inbound.GraffitiManagementUseCase;
import com.learning.hexagonalarchitecture.application.port.inbound.command.CreateGraffitiCommand;
import com.learning.hexagonalarchitecture.application.port.inbound.command.UpdateGraffitiCommand;
import com.learning.hexagonalarchitecture.application.port.inbound.response.GraffitiResponse;
import com.learning.hexagonalarchitecture.application.port.outbound.GrafitiRepository;
import com.learning.hexagonalarchitecture.application.port.outbound.GrafittiEventPublisher;
import com.learning.hexagonalarchitecture.domain.exception.GrafittiNotFoundException;
import com.learning.hexagonalarchitecture.domain.model.Graffiti;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class GrafittiManagementService implements GraffitiManagementUseCase {
    private final GrafitiRepository grafitiRepository;
    private final GrafittiEventPublisher eventPublisher;
    private final GrafittiMapper grafitMapper;

    @Override
    public GraffitiResponse createGraffiti(CreateGraffitiCommand command) {
        Graffiti graffiti = Graffiti.createGraffiti(command.getName(),
                command.getDescription(),
                command.getLocation(),
                command.getPainters(),
                command.getForSale(),
                command.getAttributes());

        //persist to db
        Graffiti savedGraffiti = grafitiRepository.save(graffiti);

        //publish domain event
        eventPublisher.publishGrafittiCreatedEvent(savedGraffiti);

        //convert and return response
        return grafitMapper.toResponse(savedGraffiti);
    }

    @Override
    @Transactional(readOnly = true)
    public GraffitiResponse findGraffitiById(UUID id) {
        Graffiti graffiti = grafitiRepository.findById(id).orElseThrow(
                () -> new GrafittiNotFoundException(id)
        );
        return grafitMapper.toResponse(graffiti);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GraffitiResponse> findAllGraffiti() {
        List<Graffiti> graffitiList = grafitiRepository.findAll();
        return graffitiList.stream().map(grafitMapper::toResponse).toList();
    }

    @Override
    public GraffitiResponse updateGraffiti(UpdateGraffitiCommand command) {
        Graffiti graffiti = grafitiRepository.findById(command.getId())
                .orElseThrow(()-> new GrafittiNotFoundException(command.getId()));

        Graffiti updateGrafitti = graffiti.updateGraffiti(command.getName(),
                command.getDescription(),
                command.getLocation(),
                command.getPainters(),
                command.getForSale(),
                command.getAttributes());
        //persist to db
        Graffiti savedGraffiti = grafitiRepository.save(graffiti);

        //publish domain event
        eventPublisher.publishGrafittiCreatedEvent(savedGraffiti);

        //convert and return response
        return grafitMapper.toResponse(savedGraffiti);
    }

    @Override
    public void deleteGraffiti(UUID id) {
        Graffiti graffiti = grafitiRepository.findById(id).orElseThrow(()-> new GrafittiNotFoundException(id));

        grafitiRepository.deleteById(graffiti.getId());
        eventPublisher.publishGrafittiDeletedEvent(graffiti.getId());
    }

    @Override
    public void deleteAllGraffiti() {
        grafitiRepository.deleteAllGraffiti();
        eventPublisher.publishCloseDownProtocolEvent(ZonedDateTime.now());
    }

    @Override
    public GraffitiResponse findGraffitiByName(String name) {
        Graffiti graffiti = grafitiRepository.findByName(name).orElseThrow(
                () -> new GrafittiNotFoundException(name)
        );
        return grafitMapper.toResponse(graffiti);
    }

    @Override
    public GraffitiResponse markGraffitiAsOnSale(UUID id) {
        Graffiti graffiti = grafitiRepository.findById(id).orElseThrow(()-> new GrafittiNotFoundException(id));

        graffiti.markForSale();

        Graffiti savedGraffiti = grafitiRepository.save(graffiti);
        eventPublisher.publishGraffitiEnlistedForSaleEvent(savedGraffiti);

        return grafitMapper.toResponse(savedGraffiti);
    }

    @Override
    public GraffitiResponse markGraffitiAsNotOnSale(UUID id) {
        Graffiti graffiti = grafitiRepository.findById(id).orElseThrow(()-> new GrafittiNotFoundException(id));

        graffiti.markForSale();

        Graffiti savedGraffiti = grafitiRepository.save(graffiti);
        eventPublisher.publishGraffitiEnlistedForSaleEvent(savedGraffiti);

        return grafitMapper.toResponse(savedGraffiti);
    }
}
