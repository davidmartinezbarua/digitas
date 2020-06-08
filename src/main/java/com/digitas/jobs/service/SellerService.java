package com.digitas.jobs.service;

import com.digitas.jobs.controller.dto.SellerDTO;
import com.digitas.jobs.domain.Seller;
import com.digitas.jobs.error.ResourceNotFoundException;

public interface SellerService {

    Seller retrieveSellerById(Long id);

    Seller addSeller(SellerDTO sellerDTO);

    Seller updateSeller(Long id, SellerDTO sellerDTO);

    void deleteSeller(Long id);
}