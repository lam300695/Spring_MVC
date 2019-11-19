package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer finById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
