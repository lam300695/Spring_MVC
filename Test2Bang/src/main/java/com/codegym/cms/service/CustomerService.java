package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Deparment;

import java.util.Date;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findByDeparment(Deparment deparment);
}
