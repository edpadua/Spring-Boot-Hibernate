package com.javadevjournal.springboothibernate.service;

import java.util.List;

import com.javadevjournal.springboothibernate.dto.CustomerData;

public interface CustomerService {
	CustomerData saveCustomer(CustomerData customer);
    boolean deleteCustomer(final Long customerId);
    List<CustomerData> getAllCustomers();
    CustomerData getCustomerById(final Long customerId);
}
