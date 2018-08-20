package com.ifisolution.flyrest.services;

import com.ifisolution.flyrest.domain.Customer;
import com.ifisolution.flyrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer findCustomerByID(Long id) {
        Optional<Customer> recipeOptional = customerRepository.findById(id);

        return recipeOptional.get();
    }

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> recipeOptional = customerRepository.findAll();

        return recipeOptional;
    }

    @Override
    public Customer save(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
