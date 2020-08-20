package com.accesscontrol.access.client;

import com.accesscontrol.access.dto.GetCustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER", configuration = CustomerClientConfiguration.class)
public interface CustomerClient {

  @GetMapping("/cliente/{id}")
  GetCustomerResponse getById(@PathVariable Long id);
}
