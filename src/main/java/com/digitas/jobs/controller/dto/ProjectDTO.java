package com.digitas.jobs.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectDTO {

    private String description;
    private Double maxBudget;
    private LocalDateTime endingDate;
}
