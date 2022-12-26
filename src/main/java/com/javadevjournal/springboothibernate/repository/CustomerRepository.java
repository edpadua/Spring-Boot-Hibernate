package com.javadevjournal.springboothibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javadevjournal.springboothibernate.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
