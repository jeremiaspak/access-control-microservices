package com.accesscontrol.access.repository;

import com.accesscontrol.access.entity.Access;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccessRepository extends CrudRepository<Access, Long> {

  Optional<Access> getByCustomerIdAndDoorId(Long customerId, Long doorId);

  @Transactional
  @Modifying
  Integer deleteByCustomerIdAndDoorId(Long customerId, Long doorId);
}
