package com.codegym.service.Impl;

import com.codegym.model.Sector;
import com.codegym.repository.SectorRepository;
import com.codegym.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;

public class SectorServiceImpl implements SectorService {
    @Autowired
    SectorRepository sectorRepository;
    @Override
    public Iterable<Sector> findAll() {
        return sectorRepository.findAll();
    }

    @Override
    public Sector findById(Long id) {
        return sectorRepository.findOne(id);
    }

    @Override
    public void save(Sector sector) {
        sectorRepository.save(sector);
    }

    @Override
    public void remove(Long id) {
        sectorRepository.delete(id);
    }
}