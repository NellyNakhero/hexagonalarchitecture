package com.learning.hexagonalarchitecture.infrastructure.output.event;

import com.learning.hexagonalarchitecture.application.port.outbound.GrafittiEventPublisher;
import com.learning.hexagonalarchitecture.domain.model.Graffiti;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class LoggingGraffitiEventPublisher implements GrafittiEventPublisher {
    private static  final Logger LOGGER = LoggerFactory.getLogger(LoggingGraffitiEventPublisher.class);
    @Override
    public void publishGrafittiCreatedEvent(Graffiti graffiti) {
        LOGGER.info("Publishing Graffiti Created Event for graffiti by id {}", graffiti.getId());
    }

    @Override
    public void publishGrafittiUpdatedEvent(Graffiti graffiti) {
        LOGGER.info("Publishing Graffiti Updated Event for graffiti by id {}", graffiti.getId());

    }

    @Override
    public void publishGrafittiDeletedEvent(UUID id) {
        LOGGER.info("Publishing Graffiti Deleted Event for graffiti by id {}", id);
    }

    @Override
    public void publishGraffitiEnlistedForSaleEvent(Graffiti graffiti) {
        LOGGER.info("Publishing Graffiti Enlisted for Sale Event for graffiti by id {}", graffiti.getId());
    }

    @Override
    public void publishGraffitiNotEnlistedForSaleEvent(UUID id) {
        LOGGER.info("Publishing Graffiti Delisted for Sale Event for graffiti by id {}", id);
    }

    @Override
    public void publishCloseDownProtocolEvent(ZonedDateTime zonedDateTime) {
        LOGGER.info("Publishing Graffiti Close-down protocol activated Event for graffiti started at {}", zonedDateTime);
    }
}
