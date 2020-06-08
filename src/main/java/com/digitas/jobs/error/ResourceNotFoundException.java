package com.digitas.jobs.error;

public class ResourceNotFoundException extends RuntimeException  {
    public ResourceNotFoundException(Long id) {
        super(String.format("Resource not found", id));
    }
}
