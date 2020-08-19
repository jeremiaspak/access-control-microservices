package com.accesscontrol.customer.mapper;

import com.accesscontrol.customer.dto.CreateCustomerRequest;
import com.accesscontrol.customer.dto.CreateCustomerResponse;
import com.accesscontrol.customer.dto.GetCustomerResponse;
import com.accesscontrol.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  GetCustomerResponse customerToGetCustomerResponse(Customer customer);
  Iterable<GetCustomerResponse> customerToGetCustomerResponse(Iterable<Customer> customers);

  Customer createCustomerRequestToCustomer(CreateCustomerRequest customerRequest);
  CreateCustomerResponse customerToCreateCustomerResponse(Customer customer);
}
