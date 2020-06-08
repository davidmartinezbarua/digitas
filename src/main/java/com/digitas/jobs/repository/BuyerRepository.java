package com.digitas.jobs.repository;

import com.digitas.jobs.domain.Buyer;
import org.springframework.data.repository.CrudRepository;

public interface BuyerRepository   extends CrudRepository<Buyer, Long> {
}
