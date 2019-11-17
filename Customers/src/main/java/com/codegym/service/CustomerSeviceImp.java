package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerSeviceImp implements CustomerSevice {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Lam", "lam300695@gmail.com", "Hai Duong"));
        customers.put(2, new Customer(2, "Hieu", "hieu191196@gmail.com", "Ha Noi"));
        customers.put(3, new Customer(3, "Tuan", "tuan20101965@gmail.com", "Ha Noi"));
        customers.put(4, new Customer(4, "Lam", "mai291999@gmail.com", "Paris"));
    }

    @Override
    public List<Customer> FindAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
