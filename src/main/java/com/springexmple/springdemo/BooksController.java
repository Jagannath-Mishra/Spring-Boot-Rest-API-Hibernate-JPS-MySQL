package com.springexmple.springdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	 
	@RequestMapping("/")
	public String home(Map<String, Object> model) {
	 
	    LOGGER.debug("This is a debug message");
	    LOGGER.info("This is an info message");
	    LOGGER.warn("This is a warn message");
	    LOGGER.error("This is an error message");
	 
	    model.put("message", "HowToDoInJava Reader !!");
	    return "index";
	}

	static List<Book> al = new ArrayList<Book>();

	@GetMapping("/books")
	public List<Book> getAllBooks() {

		return al;
	}

	@GetMapping("/hello")
	public String helloAPI() {

		return new String("This is my first API Get method");
	}

	@PostMapping("/helloPost")
	public String HelloPost(@RequestBody String name) {

		return "Hi " + name;

	}

	@PostMapping("/books")
	public List<Book> addBooks(@RequestBody Book book) {
		al.add(book);
		return al;

	}
	
	@GetMapping("/hello-path/{name}")
	public String testPathVariable(@PathVariable String name){
		return "Welcome to " + name;
	}

}