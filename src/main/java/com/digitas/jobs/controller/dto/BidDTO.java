package com.digitas.jobs.controller.dto;

import lombok.Data;

@Data
public class BidDTO {
    Long buyerId;
    Long projectId;
    Double price;
}
