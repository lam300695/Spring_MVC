package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Deparment;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByDeparment(Deparment deparment);
}