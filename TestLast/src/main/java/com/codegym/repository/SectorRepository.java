package com.codegym.repository;

import com.codegym.model.Sector;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SectorRepository extends PagingAndSortingRepository<Sector,Long> {
}