package com.codegym.cms.service.impl;

import com.codegym.cms.model.Deparment;
import com.codegym.cms.repository.DeparmentRepository;
import com.codegym.cms.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeparmentServiceImpl implements DeparmentService {

    @Autowired
    private DeparmentRepository deparmentRepository;

    @Override
    public Iterable<Deparment> findAll() {
        return deparmentRepository.findAll();
    }

    @Override
    public Deparment findById(Long id) {
        return deparmentRepository.findOne(id);
    }

    @Override
    public void save(Deparment deparment) {
        deparmentRepository.save(deparment);
    }

    @Override
    public void remove(Long id) {
        deparmentRepository.delete(id);
    }
}
