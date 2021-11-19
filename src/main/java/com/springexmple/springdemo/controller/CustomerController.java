package com.springexmple.springdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springexmple.springdemo.dto.CustomerData;
import com.springexmple.springdemo.exceptions.CustomeException;
import com.springexmple.springdemo.service.AuthService;
import com.springexmple.springdemo.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	
	private static final Logger LOGGER=LoggerFactory.getLogger(CustomerController.class);

	/* @Resource(name = "customerService")
	 private CustomerService customerService;*/
	 
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	
	private AuthService authService;
		 
	
	
	@ApiOperation(value = "View all  customers Details", response = Iterable.class)
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Successfully retrieved list"),
	@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
	 
	@GetMapping(produces={"application/xml"})
	    public List < CustomerData > getCustomers() {
		
		LOGGER.info("Get method started running");
		 
	
		 return customerService.getAllCustomers();
	    }
	 
	 
	 
	 @GetMapping(value = "/customer/{id}", produces = { "application/xml", "application/json" })
	    public CustomerData getCustomer(@PathVariable Long id, @RequestHeader("username") String username, @RequestHeader("password") String password) throws CustomeException {
		  
		    boolean isAuth = authService.getAuth(username, password);
		   
		    if(isAuth)
		    {
	        return customerService.getCustomerById(id);
		    }
		    else
		    {
		    throw new CustomeException("User not Authorized ");	
		    }
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