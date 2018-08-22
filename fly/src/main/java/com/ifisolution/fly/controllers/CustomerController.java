package com.ifisolution.fly.controllers;

import com.ifisolution.fly.domain.Customer;
import com.ifisolution.fly.services.CustomerService;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("admin/customer")
public class CustomerController {
    private final String domain = "http://localhost:8080";

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
    public String saveOrUpdate(@ModelAttribute Customer customer) throws IOException {
//        Customer savedCustomer = customerService.save(customer);
        saveCustomer(customer);

//        return "redirect:/customer/" + customer.getId() + "/show";
        return "redirect:/admin/customer";
    }
    @GetMapping(value = {"","/","index"})
    public String getAllCustomer(Model model){
        model.addAttribute("customers",customerService.findAllCustomer());
        return "customer/customers";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomerById(@PathVariable String id) throws IOException {
        delete(id);
//        customerService.deleteCustomer(Long.valueOf(id));
        return "redirect:/admin/customer";
    }

    public boolean saveCustomer(Customer cus) throws IOException {
        boolean check = true;
        JSONObject json = new JSONObject();
        json.put("customerName", cus.getCustomerName());
        json.put("otherDetails", cus.getOtherDetails());

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        try {
            //HttpPost request = new HttpPost(domain+"/api/customer");
            HttpPost request = new HttpPost(domain + "/customer/new");
            StringEntity params = new StringEntity(json.toString());
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            httpClient.execute(request);
            check = true;
        } catch (Exception ex) {
            check = false;
        } finally {
            httpClient.close();
        }
        return check;
    }

    public boolean delete(String id) throws IOException {
        boolean check = true;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            //HttpPost request = new HttpPost(domain+"/api/customer");
            HttpDelete request = new HttpDelete(domain + "/customer/delete/" + id);
            request.addHeader("content-type", "application/json");
            httpClient.execute(request);
        } catch (Exception ex) {
            check = false;
        }
        return check;
    }

    public boolean showCustomer(Customer cus) {
        boolean check = true;
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            //HttpPost request = new HttpPost(domain+"/api/customer");
            HttpGet request = new HttpGet(domain + "/customer/get");
            request.addHeader("content-type", "application/json");
            httpClient.execute(request);
        } catch (Exception ex) {
            check = false;
        }
        return check;
    }
}