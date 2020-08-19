package com.accesscontrol.customer.repository;

import com.accesscontrol.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> { }
