package com.codegym.cms.service.impl;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Deparment;
import com.codegym.cms.repository.CustomerRepository;
import com.codegym.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public Iterable<Customer> findByDeparment(Deparment deparment) {
        return customerRepository.findAllByDeparment(deparment);
    }
}