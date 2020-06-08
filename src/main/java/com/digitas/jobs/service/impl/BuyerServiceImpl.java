package com.digitas.jobs.service.impl;

import com.digitas.jobs.controller.dto.BuyerDTO;
import com.digitas.jobs.domain.Buyer;
import com.digitas.jobs.error.ResourceNotFoundException;
import com.digitas.jobs.repository.BuyerRepository;
import com.digitas.jobs.service.BuyerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    private BuyerRepository buyerRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository,
                             ModelMapper modelMapper) {
        this.buyerRepository = buyerRepository;
        this.modelMapper = modelMapper;
    }


    public Buyer retrieveBuyerById(Long id){
        return buyerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Buyer addBuyer(BuyerDTO buyerDTO) {

        Buyer buyer = modelMapper.map(buyerDTO, Buyer.class);
        return buyerRepository.save(buyer);
    }

    public Buyer updateBuyer(Long id, BuyerDTO buyerDTO) {

        Buyer buyer =retrieveBuyerById(id);
        modelMapper.map(buyerDTO, buyer);
        return buyerRepository.save(buyer);
    }

    public void deleteBuyer(Long id) {
        buyerRepository.delete(retrieveBuyerById(id));
    }
}
