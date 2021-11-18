package com.springexmple.springdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

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