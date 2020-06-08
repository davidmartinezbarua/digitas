package com.digitas.jobs.repository;

import com.digitas.jobs.JobsMarketApplication;
import com.digitas.jobs.domain.Bid;
import com.digitas.jobs.domain.Buyer;
import com.digitas.jobs.domain.Project;
import com.digitas.jobs.domain.Seller;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= JobsMarketApplication.class)
public class RepositoryInMemoryTest {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BidRepository bidRepository;

    @Test
    public void givenSellerRepository_whenSaveAndRetrieveSeller_thenOK() {
        Seller seller = sellerRepository
                .save(new Seller());
        Optional<Seller> foundSeller = sellerRepository.findById(seller.getId());
        Assert.assertEquals(seller.getId(), foundSeller.get().getId());
    }

    @Test
    public void givenProjectRepository_whenSaveAndRetrieveProject_thenOK() {
        Project  project= projectRepository
                .save(new Project());
        Optional<Project> foundProject = projectRepository.findById(project.getId());
        Assert.assertEquals(project.getId(), foundProject.get().getId());
    }

    @Test
    public void givenBidRepository_whenSaveAndRetrieveBid_thenOK() {
        Bid bid = bidRepository
                .save(new Bid());
        Optional<Bid> foundBid = bidRepository.findById(bid.getId());
        Assert.assertEquals(bid.getId(), foundBid.get().getId());
    }

    @Test
    public void givenBuyerRepository_whenSaveAndRetrieveBuyer_thenOK() {
        Buyer buyer = buyerRepository
                .save(new Buyer());
        Optional<Buyer> foundBuyer = buyerRepository.findById(buyer.getId());
        Assert.assertEquals(buyer.getId(), foundBuyer.get().getId());
    }
}
