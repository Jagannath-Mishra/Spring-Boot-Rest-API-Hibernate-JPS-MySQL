package com.springexmple.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springexmple.springdemo.dto.CustomerData;
import com.springexmple.springdemo.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customers")
public class CustomerController {


	/* @Resource(name = "customerService")
	 private CustomerService customerService;*/
	 
	@Autowired
	private CustomerService customerService;
		 
	@ApiOperation(value = "View all  customers Details", response = Iterable.class)
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Successfully retrieved list"),
	@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	 @GetMapping
	    public List < CustomerData > getCustomers() {
	     
		 return customerService.getAllCustomers();
	    }
	 
	 
	 
	 @GetMapping(value = "/customer/{id}", produces = { "application/xml", "application/json" })
	    public CustomerData getCustomer(@PathVariable Long id) {
	        return customerService.getCustomerById(id);
	    }
	
	 
	 
	 //@PostMapping("/customer")
	 @RequestMapping(value = "/customer", method= RequestMethod.POST, produces = "application/xml", consumes = "application/xml")
	    public CustomerData saveCustomer(final @RequestBody CustomerData customerData) {
	        return customerService.saveCustomer(customerData);
	    }
	 
	 
	 
	 @DeleteMapping("/customer/{id}")
	    public Boolean deleteCustomer(@PathVariable Long id) {
	        return customerService.deleteCustomer(id);
	    }
	 
	 @PutMapping(value = "/customer/{id}", produces = { "application/json", "application/xml" }, consumes = MediaType.ALL_VALUE)
	 public CustomerData updateCustomer(final @RequestBody CustomerData customerData, @PathVariable Long id){
		 return customerService.updateCustomer(customerData, id);
	 }

}