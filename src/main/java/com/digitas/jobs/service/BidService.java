package com.digitas.jobs.service;

import com.digitas.jobs.controller.dto.BidDTO;
import com.digitas.jobs.domain.Bid;

public interface BidService {
    BidDTO addBid(BidDTO bidDTO);
}
