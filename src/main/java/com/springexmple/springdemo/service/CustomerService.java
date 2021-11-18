package com.springexmple.springdemo.service;

import java.util.List;

import com.springexmple.springdemo.dto.CustomerData;
import com.springexmple.springdemo.entity.Customer;

public interface CustomerService {

	CustomerData saveCustomer(CustomerData customer);

	Customer populateCustomerEntity(CustomerData customerData);

	List<CustomerData> getAllCustomers();

	CustomerData getCustomerById(Long customerId);

	boolean deleteCustomer(Long customerId);

	CustomerData updateCustomer(CustomerData customer, Long id);

}
