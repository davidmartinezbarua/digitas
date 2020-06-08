package com.digitas.jobs.controller;

import com.digitas.jobs.controller.dto.SellerDTO;
import com.digitas.jobs.domain.Seller;
import com.digitas.jobs.service.impl.SellerServiceImpl;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sellers")
public class SellerController {

    private SellerServiceImpl sellerService;

    @Autowired
    public SellerController(SellerServiceImpl sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping(path = "{id}")
    @ApiOperation(value = "Get Seller by Id")
    public ResponseEntity<Seller> getSellerById(@PathVariable("id") Long id) {
        Seller seller = sellerService.retrieveSellerById(id);

        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Create Seller")
    public ResponseEntity<Seller> createSeller(@NotNull @RequestBody SellerDTO sellerDTO) {
        Seller newSeller = sellerService.addSeller(sellerDTO);

        return new ResponseEntity<>(newSeller, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    @ApiOperation(value = "Update Seller")
    public ResponseEntity<Seller> updateSeller(@PathVariable("id") Long id,
                                               @NotNull @RequestBody SellerDTO sellerDTO) {
        Seller updatedSeller = sellerService.updateSeller(id, sellerDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "{id}")
    @ApiOperation(value = "Delete Seller by Id")
    public ResponseEntity deleteSeller(@PathVariable("id") Long id) {
        sellerService.deleteSeller(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}