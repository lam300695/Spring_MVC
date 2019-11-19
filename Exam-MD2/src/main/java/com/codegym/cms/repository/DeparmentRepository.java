package com.codegym.cms.repository;

import com.codegym.cms.model.Deparment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeparmentRepository extends PagingAndSortingRepository<Deparment, Long> {
}
