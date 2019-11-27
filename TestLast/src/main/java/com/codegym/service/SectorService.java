package com.codegym.service;

import com.codegym.model.Sector;

public interface SectorService  {
    Iterable<Sector> findAll();
    Sector findById(Long id);
    void save(Sector sector);
    void remove(Long id);
}