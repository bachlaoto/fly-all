package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer findCustomerByID(Long id);

    List<Customer> findAllCustomer();

    Customer save(Customer customer);

    void deleteCustomer(Long id);

}
