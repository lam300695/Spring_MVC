package com.codegym.cms.repository;

import java.util.List;

public interface Repository<E> {
    List<E> findAll();

    E findById(Long id);

    void save(E model);

    void remove(Long id);
}
