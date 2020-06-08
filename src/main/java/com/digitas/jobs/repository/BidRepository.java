package com.digitas.jobs.repository;

import com.digitas.jobs.domain.Bid;
import org.springframework.data.repository.CrudRepository;

public interface BidRepository  extends CrudRepository<Bid, Long> {
}
