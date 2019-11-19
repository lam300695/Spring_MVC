package com.codegym.cms.service;

import com.codegym.cms.model.Deparment;

public interface DeparmentService {
    Iterable<Deparment> findAll();

    Deparment findById(Long id);

    void save(Deparment deparment);

    void remove(Long id);
}
