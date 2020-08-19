package com.accesscontrol.door.service;

import com.accesscontrol.door.entity.Door;
import com.accesscontrol.door.exception.DoorNotFoundException;
import com.accesscontrol.door.repository.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoorService {

  @Autowired
  DoorRepository repository;

  public Iterable<Door> findAll() {
    return repository.findAll();
  }

  public Door getById(Long id) throws DoorNotFoundException {
    return repository.findById(id).orElseThrow(DoorNotFoundException::new);
  }

  public Door create(Door door) {
    return repository.save(door);
  }
}
