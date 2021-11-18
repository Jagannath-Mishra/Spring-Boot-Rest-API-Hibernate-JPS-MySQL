package com.springexmple.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springexmple.springdemo.dto.CustomerData;
import com.springexmple.springdemo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {


	/* @Resource(name = "customerService")
	 private CustomerService customerService;*/
	 
	@Autowired
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
	 
	 @PutMapping("/customer/{id}")
	 public CustomerData updateCustomer(final @RequestBody CustomerData customerData, @PathVariable Long id){
		 return customerService.updateCustomer(customerData, id);
	 }

}