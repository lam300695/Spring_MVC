package com.codegym.service;

import com.codegym.model.Item;

import com.codegym.model.Sector;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService {
    Page<Item> findAll(Pageable pageable);

    Item findById(Long id);

    void save(Item item);

    void remove(Long id);

    Page<Item> findAllByNameContaining(String name, Pageable pageable);
    Iterable<Item> findAllBySector(Sector sector);

    Page<Item> findAllBySector(Pageable pageable, Sector sector);

    Page<Item> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Item> findAllByOrderByPriceDesc(Pageable pageable);

}