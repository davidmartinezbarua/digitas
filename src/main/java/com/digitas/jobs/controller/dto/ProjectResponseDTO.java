package com.digitas.jobs.controller.dto;

import com.digitas.jobs.domain.Bid;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProjectResponseDTO {

    private String description;
    private Double maxBudget;
    private LocalDateTime endingDate;
    private Long sellerId;
    private Boolean active;
    private Bid lowestBid;
}
