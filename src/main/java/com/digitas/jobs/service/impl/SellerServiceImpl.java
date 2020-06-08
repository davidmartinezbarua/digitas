package com.digitas.jobs.service.impl;

import com.digitas.jobs.controller.dto.SellerDTO;
import com.digitas.jobs.domain.Seller;
import com.digitas.jobs.error.ResourceNotFoundException;
import com.digitas.jobs.repository.SellerRepository;
import com.digitas.jobs.service.SellerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    private SellerRepository sellerRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository,
                             ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
    }


    public Seller retrieveSellerById(Long id){
        return sellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Seller addSeller(SellerDTO sellerDTO) {

        Seller seller = modelMapper.map(sellerDTO, Seller.class);
        return sellerRepository.save(seller);
    }

    public Seller updateSeller(Long id, SellerDTO sellerDTO) {

        Seller seller =retrieveSellerById(id);
        modelMapper.map(sellerDTO, seller);
        return sellerRepository.save(seller);
    }

    public void deleteSeller(Long id) {
        sellerRepository.delete(retrieveSellerById(id));
    }
}
