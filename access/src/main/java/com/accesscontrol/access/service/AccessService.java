package com.accesscontrol.access.service;

import com.accesscontrol.access.client.CustomerClient;
import com.accesscontrol.access.client.DoorClient;
import com.accesscontrol.access.dto.GetCustomerResponse;
import com.accesscontrol.access.dto.GetDoorResponse;
import com.accesscontrol.access.entity.Access;
import com.accesscontrol.access.exceptions.AccessNotFoundException;
import com.accesscontrol.access.exceptions.CustomerNotFoundException;
import com.accesscontrol.access.exceptions.DoorNotFoundException;
import com.accesscontrol.access.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {

  @Autowired
  private AccessRepository repository;

  @Autowired
  private CustomerClient customerClient;

  @Autowired
  private DoorClient doorClient;

  public Iterable<Access> findAll() {
    return repository.findAll();
  }

  public Access getById(Long id) throws AccessNotFoundException {
    return repository.findById(id).orElseThrow(AccessNotFoundException::new);
  }

  public Access getByCustomerIdAndDoorId(
    Long customerId,
    Long doorId
  ) throws AccessNotFoundException {
    return repository.getByCustomerIdAndDoorId(customerId, doorId)
      .orElseThrow(AccessNotFoundException::new);
  }

  public Access create(
    Access access
  ) throws CustomerNotFoundException, DoorNotFoundException {
    GetCustomerResponse customerResponse = customerClient.getById(access.getCustomerId());
    GetDoorResponse doorResponse = doorClient.getById(access.getDoorId());
    return repository.save(access);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  public Integer deleteByCustomerIdAndDoorId(
    Long customerId,
    Long doorId
  ) throws CustomerNotFoundException, DoorNotFoundException {
    GetCustomerResponse customerResponse = customerClient.getById(customerId);
    GetDoorResponse doorResponse = doorClient.getById(doorId);
    return repository.deleteByCustomerIdAndDoorId(customerId, doorId);
  }
}
