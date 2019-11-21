package com.codegym.service;

import com.codegym.model.Category;
import com.codegym.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void delete(Long id);
}