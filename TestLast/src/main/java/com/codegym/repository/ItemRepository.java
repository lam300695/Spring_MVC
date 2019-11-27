package com.codegym.repository;

import com.codegym.model.Item;

import com.codegym.model.Sector;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
    Page<Item> findAllByNameContaining(String name, Pageable pageable);

    Iterable<Item> findAllBySector(Sector sector);
    Page<Item> findAllBySector(Pageable pageable, Sector sector);

    Page<Item> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Item> findAllByOrderByPriceDesc(Pageable pageable);
}