package com.javadevjournal.springboothibernate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javadevjournal.springboothibernate.dto.CustomerData;
import com.javadevjournal.springboothibernate.service.CustomerService;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	 @Resource(name = "customerService")
	    private CustomerService customerService;
	 
	 @GetMapping
	    public List < CustomerData > getCustomers() {
	        return customerService.getAllCustomers();
	    }
	 
	 @GetMapping("/customer/{id}")
	    public CustomerData getCustomer(@PathVariable Long id) {
	        return customerService.getCustomerById(id);
	    }
	 
	 @PostMapping("/customer")
	    public CustomerData saveCustomer(final @RequestBody CustomerData customerData) {
	        return customerService.saveCustomer(customerData);
	    }
	 
	 @DeleteMapping("/customer/{id}")
	    public Boolean deleteCustomer(@PathVariable Long id) {
	        return customerService.deleteCustomer(id);
	    }

}
