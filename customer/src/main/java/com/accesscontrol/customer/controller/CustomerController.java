package com.accesscontrol.customer.controller;

import com.accesscontrol.customer.dto.CreateCustomerRequest;
import com.accesscontrol.customer.dto.CreateCustomerResponse;
import com.accesscontrol.customer.dto.GetCustomerResponse;
import com.accesscontrol.customer.entity.Customer;
import com.accesscontrol.customer.exception.CustomerNotFoundException;
import com.accesscontrol.customer.mapper.CustomerMapper;
import com.accesscontrol.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public Iterable<GetCustomerResponse> findAll() {
    return CustomerMapper.INSTANCE.customerToGetCustomerResponse(customerService.findAll());
  }

  @GetMapping("/{id}")
  public GetCustomerResponse getById(@PathVariable Long id) {
    return CustomerMapper.INSTANCE.customerToGetCustomerResponse(
      customerService.getById(id)
    );
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreateCustomerResponse create(@Valid @RequestBody CreateCustomerRequest customerRequest) {
    Customer customer = customerService.create(
      CustomerMapper.INSTANCE.createCustomerRequestToCustomer(customerRequest)
    );
    return CustomerMapper.INSTANCE.customerToCreateCustomerResponse(customer);
  }
}
