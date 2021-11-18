package com.springexmple.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springexmple.springdemo.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> { }