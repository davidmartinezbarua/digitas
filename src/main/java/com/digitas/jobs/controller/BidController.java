package com.digitas.jobs.controller;

import com.digitas.jobs.controller.dto.BidDTO;
import com.digitas.jobs.service.impl.BidServiceImpl;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/bids")
public class BidController {

    private BidServiceImpl bidService;

    @Autowired
    public BidController(BidServiceImpl bidService) {
        this.bidService = bidService;
    }

    @PostMapping
    @ApiOperation(value = "Create new Bid")
    public ResponseEntity<BidDTO> createBid(@NotNull @RequestBody BidDTO bidDTO) {
        BidDTO responseDTO = bidService.addBid(bidDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
