package com.accesscontrol.customer.service;

import com.accesscontrol.customer.entity.Customer;
import com.accesscontrol.customer.exception.CustomerNotFoundException;
import com.accesscontrol.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository repository;

  public Iterable<Customer> findAll() {
    return repository.findAll();
  }

  public Customer getById(Long id) throws CustomerNotFoundException {
    return repository.findById(id).orElseThrow(CustomerNotFoundException::new);
  }

  public Customer create(Customer customer) {
    return repository.save(customer);
  }
}
