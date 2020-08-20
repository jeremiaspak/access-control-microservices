package com.accesscontrol.access.client;

import com.accesscontrol.access.dto.GetDoorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DOOR", configuration = DoorClientConfiguration.class)
public interface DoorClient {

  @GetMapping("/porta/{id}")
  GetDoorResponse getById(@PathVariable Long id);
}
