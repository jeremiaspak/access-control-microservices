package com.accesscontrol.door.repository;

import com.accesscontrol.door.entity.Door;
import org.springframework.data.repository.CrudRepository;

public interface DoorRepository extends CrudRepository<Door, Long> { }
