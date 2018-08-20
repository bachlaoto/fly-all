package com.ifisolution.fly.controllers;

import com.ifisolution.fly.domain.Customer;
import com.ifisolution.fly.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    @RequestMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("customer", customerService.findCustomerByID(new Long(id)));

        return "customer/oneCustomer";
    }

    @GetMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customerForm";
    }

    @GetMapping("/{id}/update")
    public String UpdateCustomer(@PathVariable String id, Model model){
        model.addAttribute("customer", customerService.findCustomerByID(Long.valueOf(id)));
        return "customer/customerForm";
    }

    @PostMapping("/customer")
    public String saveOrUpdate(@ModelAttribute Customer customer ){
        Customer savedCustomer = customerService.save(customer);
        return "redirect:/customer/" + savedCustomer.getId() + "/show";
    }
    @GetMapping(value = {"","/","index"})
    public String getAllCustomer(Model model){
        model.addAttribute("customers",customerService.findAllCustomer());
        return "customer/customers";
    }

    @GetMapping("{id}/delete")
    public String deleteCustomerById(@PathVariable String id){

        customerService.deleteCustomer(Long.valueOf(id));
        return "redirect:/customer";
    }
}