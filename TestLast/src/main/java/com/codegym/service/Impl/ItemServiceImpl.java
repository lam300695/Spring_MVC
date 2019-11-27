package com.codegym.service.Impl;

import com.codegym.model.Item;
import com.codegym.model.Sector;
import com.codegym.repository.ItemRepository;
import com.codegym.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Override
    public Page<Item> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findOne(id);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void remove(Long id) {
        itemRepository.delete(id);
    }

    @Override
    public Page<Item> findAllByNameContaining(String name, Pageable pageable) {
        return itemRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Item> findAllBySector(Pageable pageable, Sector sector) {
        return itemRepository.findAllBySector(pageable,sector);
    }

    @Override
    public Page<Item> findAllByOrderByPriceAsc(Pageable pageable) {
        return itemRepository.findAllByOrderByPriceAsc(pageable);
    }

    @Override
    public Page<Item> findAllByOrderByPriceDesc(Pageable pageable) {
        return itemRepository.findAllByOrderByPriceDesc(pageable);
    }

    @Override
    public Iterable<Item> findAllBySector(Sector sector) {
        return itemRepository.findAllBySector(sector);
    }

}