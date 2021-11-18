package com.springexmple.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexmple.springdemo.dto.CustomerData;
import com.springexmple.springdemo.entity.Customer;
import com.springexmple.springdemo.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
    private CustomerRepository customerRepository;
	
	
	
	@Override
    public List < CustomerData > getAllCustomers() {
        List < CustomerData > customers = new ArrayList <> ();
        
        
        List <Customer> customerList = customerRepository.findAll();
        
        for(Customer k:customerList){
          customers.add( new CustomerData(k.getId(),k.getFirstName(),k.getLastName(),k.getEmail(),k.getPhone()) );
        }
        
      /*customerList.forEach(customer -> { customers.add(populateCustomerData(customer));  });*/
        
        
        return customers;
    }
	
	
	  @Override
	    public CustomerData getCustomerById(Long customerId) {
	        return populateCustomerData(customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Customer not found")));
	    }
		
	@Override
	public CustomerData saveCustomer(CustomerData customer) {
		
        Customer customerModel = populateCustomerEntity(customer);
        return populateCustomerData(customerRepository.save(customerModel));
    }
	
	
	@Override
	public CustomerData updateCustomer(CustomerData customer, Long id){
		Customer custumerDbData =customerRepository.getById(id);
		custumerDbData =  updateCustomerData(customer);
		return(populateCustomerData(customerRepository.save(custumerDbData)));
		
	}
	
	
	@Override
    public boolean deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }
	
	
	
	@Override
	public Customer populateCustomerEntity(CustomerData customerData) {
	        Customer customer = new Customer();
	        customer.setFirstName(customerData.getFirstName());
	        customer.setLastName(customerData.getLastName());
	        customer.setEmail(customerData.getEmail());
	        customer.setPhone(customerData.getPhone());
	        return customer;
	
	
	
	}
	
	
	
	private CustomerData populateCustomerData(final Customer customer) {
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setFirstName(customer.getFirstName());
        customerData.setLastName(customer.getLastName());
        customerData.setEmail(customer.getEmail());
        customerData.setPhone(customer.getPhone());
        return customerData;
    }

	
	private Customer updateCustomerData(final CustomerData customer) {
        Customer customerData = new Customer();
        customerData.setId(customer.getId());
        customerData.setFirstName(customer.getFirstName());
        customerData.setLastName(customer.getLastName());
        customerData.setEmail(customer.getEmail());
        return customerData;
    }
}
