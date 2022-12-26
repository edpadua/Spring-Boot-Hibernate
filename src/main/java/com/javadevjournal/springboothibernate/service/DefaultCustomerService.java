package com.javadevjournal.springboothibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javadevjournal.springboothibernate.dto.CustomerData;
import com.javadevjournal.springboothibernate.model.Customer;
import com.javadevjournal.springboothibernate.repository.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service("customerService")
public class DefaultCustomerService implements CustomerService{
	
	@Autowired
    private CustomerRepository customerRepository;
	
	
	@Override
    public CustomerData saveCustomer(CustomerData customer) {
        Customer customerModel = populateCustomerEntity(customer);
        return populateCustomerData(customerRepository.save(customerModel));
    }
	
	@Override
    public boolean deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }
	
	
	public List<CustomerData> getAllCustomers() {
        List<CustomerData> customers = new ArrayList<>();
        List<Customer> customerList = customerRepository.findAll();
        customerList.forEach(customer -> {
            customers.add(populateCustomerData(customer));
        });
        return customers;
    }

	
	@Override
    public CustomerData getCustomerById(Long customerId) {
        return populateCustomerData( customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found")));
    }

	
	 
	private CustomerData populateCustomerData(final Customer customer){
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setFirstName(customer.getFirstName());
        customerData.setLastName(customer.getLastName());
        customerData.setEmail(customer.getEmail());
        return  customerData;
    }
	 
	 
	 private Customer populateCustomerEntity(CustomerData customerData) {
	        Customer customer = new Customer();
	        customer.setFirstName(customerData.getFirstName());
	        customer.setLastName(customerData.getLastName());
	        customer.setEmail(customerData.getEmail());
	        return customer;
	    }
	 
	 

}
