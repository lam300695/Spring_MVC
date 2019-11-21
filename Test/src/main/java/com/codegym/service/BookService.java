package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(Long id);

    void save(Book book);

    void delete(Long id);

    Iterable<Book> findAllByCategory(Category category);

    Page<Book> findAllByCategoryContaining(String category, Pageable pageable);
}
