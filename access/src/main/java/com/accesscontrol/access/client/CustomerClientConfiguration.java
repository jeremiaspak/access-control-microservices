package com.accesscontrol.access.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomerClientConfiguration {

  @Bean
  public ErrorDecoder getDoorErrorDecoder() {
    return new CustomerClientDecoder();
  }
}
