package com.digitas.jobs.controller;

import com.digitas.jobs.controller.dto.BuyerDTO;
import com.digitas.jobs.domain.Buyer;
import com.digitas.jobs.service.impl.BuyerServiceImpl;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/buyer")
public class BuyerController {

    private BuyerServiceImpl buyerService;

    @Autowired
    public BuyerController(BuyerServiceImpl buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping(path = "{id}")
    @ApiOperation(value = "Get Buyer by Id")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable("id") Long id) {
        Buyer buyer = buyerService.retrieveBuyerById(id);

        return new ResponseEntity<>(buyer, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create Buyer")
    public ResponseEntity<Buyer> createBuyer(@NotNull @RequestBody BuyerDTO buyerDTO) {
        Buyer newBuyer = buyerService.addBuyer(buyerDTO);

        return new ResponseEntity<>(newBuyer, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    @ApiOperation(value = "Update Buyer")
    public ResponseEntity<Buyer> updateBuyer(@PathVariable("id") Long id,
                                               @NotNull @RequestBody BuyerDTO buyerDTO) {
        Buyer updatedBuyer = buyerService.updateBuyer(id, buyerDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation(value = "Delete Buyer by Id")
    public ResponseEntity deleteBuyer(@PathVariable("id") Long id) {
        buyerService.deleteBuyer(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
