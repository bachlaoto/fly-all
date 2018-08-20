package com.ifisolution.fly.services;

import com.ifisolution.fly.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomerByID(Long id);
    List<Customer> findAllCustomer();
    Customer save(Customer customer);
    void deleteCustomer(Long id);

}
