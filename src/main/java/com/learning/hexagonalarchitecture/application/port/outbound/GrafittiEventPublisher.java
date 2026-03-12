package com.learning.hexagonalarchitecture.application.port.outbound;

import com.learning.hexagonalarchitecture.domain.model.Graffiti;

import java.time.ZonedDateTime;
import java.util.UUID;

public interface GrafittiEventPublisher {
    void publishGrafittiCreatedEvent(Graffiti graffiti);
    void  publishGrafittiUpdatedEvent(Graffiti graffiti);
    void publishGrafittiDeletedEvent(UUID id);
    void publishGraffitiEnlistedForSaleEvent(Graffiti graffiti);
    void  publishGraffitiNotEnlistedForSaleEvent(UUID id);
    void publishCloseDownProtocolEvent(ZonedDateTime zonedDateTime);
}
