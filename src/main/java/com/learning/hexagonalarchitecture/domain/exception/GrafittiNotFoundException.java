package com.learning.hexagonalarchitecture.domain.exception;

import java.util.UUID;

public class GrafittiNotFoundException extends RuntimeException {
    public GrafittiNotFoundException(UUID id) {
        super("Grafitti id " + id + " not found");
    }

    public GrafittiNotFoundException(String name) {
        super("Grafitti by name " + name + " not found");
    }
}
