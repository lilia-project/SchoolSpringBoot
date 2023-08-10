package com.lilia.project.exception;

import lombok.Getter;


@Getter
public class ResourceNotFoundException extends RuntimeException {

    private final Long resourceId;

    public ResourceNotFoundException(Long resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }

    @Override
    public String getMessage() {
        final var msg = super.getMessage();
        return msg.replace("{}", resourceId.toString());
    }
}
