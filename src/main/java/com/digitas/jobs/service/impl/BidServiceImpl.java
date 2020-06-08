package com.digitas.jobs.service.impl;

import com.digitas.jobs.controller.dto.BidDTO;
import com.digitas.jobs.domain.Bid;
import com.digitas.jobs.domain.Buyer;
import com.digitas.jobs.domain.Project;
import com.digitas.jobs.repository.BidRepository;
import com.digitas.jobs.service.BidService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;
    private ProjectServiceImpl projectService;
    private BuyerServiceImpl buyerService;
    private ModelMapper modelMapper;

    public BidServiceImpl(BidRepository bidRepository,
                          ProjectServiceImpl projectService,
                          BuyerServiceImpl buyerService,
                          ModelMapper modelMapper){
        this.bidRepository = bidRepository;
        this.projectService = projectService;
        this.buyerService = buyerService;
        this.modelMapper = modelMapper;
    }


    @Override
    public BidDTO addBid(BidDTO bidDTO) {

        Bid bid = new Bid();
        bid.setPrice(bidDTO.getPrice());
        Buyer buyer = buyerService.retrieveBuyerById(bidDTO.getBuyerId());
        Project project = projectService.findProjectById(bidDTO.getProjectId());
        bid.setBuyer(buyer);
        bid.setProject(project);
        BidDTO responseDTO = modelMapper.map(bidRepository.save(bid), BidDTO.class);
        return responseDTO;

    }
}
