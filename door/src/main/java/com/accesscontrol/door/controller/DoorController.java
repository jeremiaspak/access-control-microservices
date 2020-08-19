package com.accesscontrol.door.controller;

import com.accesscontrol.door.dto.CreateDoorRequest;
import com.accesscontrol.door.dto.CreateDoorResponse;
import com.accesscontrol.door.dto.GetDoorResponse;
import com.accesscontrol.door.entity.Door;
import com.accesscontrol.door.mapper.DoorMapper;
import com.accesscontrol.door.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/porta")
public class DoorController {

  @Autowired
  private DoorService doorService;

  @GetMapping
  public Iterable<GetDoorResponse> findAll() {
    return DoorMapper.INSTANCE.doorToGetDoorResponse(doorService.findAll());
  }

  @GetMapping("/{id}")
  public GetDoorResponse getById(@PathVariable Long id) {
    return DoorMapper.INSTANCE.doorToGetDoorResponse(doorService.getById(id));
  }

  @PostMapping
  public CreateDoorResponse create(@Valid @RequestBody CreateDoorRequest doorRequest) {
    Door door = doorService.create(
      DoorMapper.INSTANCE.createDoorRequestToDoor(doorRequest)
    );
    return DoorMapper.INSTANCE.doorToCreateDoorResponse(door);
  }
}
