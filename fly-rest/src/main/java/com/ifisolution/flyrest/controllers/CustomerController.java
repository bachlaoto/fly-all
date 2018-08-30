package com.ifisolution.flyrest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifisolution.flyrest.domain.Customer;
import com.ifisolution.flyrest.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/get")
    public List<Customer> findAllCustomer() {
        return customerService.findAllCustomer();
    }


    @RequestMapping("/{id}/show")
    public Customer showById(@PathVariable Long id) {
        return customerService.findCustomerByID(new Long(id));
    }

    @PostMapping("/new")
    public Customer newCustomer(@RequestBody String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(json, Customer.class);
        return customerService.save(customer);
    }

    @PutMapping("/update")
    public Customer UpdateCustomer(@RequestBody Customer customer) {
        Customer customerTemp = customerService.findCustomerByID(customer.getId());
        if (customerTemp != null) {
            customerService.save(customer);
            return customer;
        }
        customerService.save(customerTemp);
        return customerTemp;
    }

    //        @PutMapping("/update")
//        public void UpdateCustomer(@RequestBody String json, HttpServletResponse resp) throws IOException {
//            ObjectMapper mapper = new ObjectMapper();
//            Customer cus = mapper.readValue(json, Customer.class);
//            customerService.save(cus);
//            resp.getWriter().print(cus);
//        }
    //    @PostMapping("/customer")
//    public String saveOrUpdate(@ModelAttribute Customer customer ){
//        Customer savedCustomer = customerService.save(customer);
//        return "redirect:/customer/" + savedCustomer.getId() + "/show";
//    }
//
//
    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@PathVariable("id") String id, HttpServletResponse res) throws IOException {
//        Customer customerTemp = customerService.findCustomerByID(Long.parseLong(id));
        customerService.deleteCustomer(Long.parseLong(id));
        res.getWriter().print(id);

    }
}