package com.accesscontrol.access.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class DoorClientConfiguration {

  @Bean
  public ErrorDecoder getCustomerErrorDecoder() {
    return new DoorClientDecoder();
  }
}
