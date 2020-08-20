package com.accesscontrol.access.service;

import com.accesscontrol.access.client.CustomerClient;
import com.accesscontrol.access.client.DoorClient;
import com.accesscontrol.access.dto.GetCustomerResponse;
import com.accesscontrol.access.dto.GetDoorResponse;
import com.accesscontrol.access.entity.Access;
import com.accesscontrol.access.exceptions.AccessNotFoundException;
import com.accesscontrol.access.exceptions.CustomerNotFoundException;
import com.accesscontrol.access.exceptions.DoorNotFoundException;
import com.accesscontrol.access.model.AccessLog;
import com.accesscontrol.access.producer.AccessProducer;
import com.accesscontrol.access.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccessService {

  @Autowired
  private AccessRepository repository;

  @Autowired
  private CustomerClient customerClient;

  @Autowired
  private DoorClient doorClient;

  @Autowired
  private AccessProducer accessProducer;

  public Iterable<Access> findAll() {
    return repository.findAll();
  }

  public Access getById(Long id) throws AccessNotFoundException {
    return repository.findById(id).orElseThrow(AccessNotFoundException::new);
  }

  public Access getByCustomerIdAndDoorId(
    Long customerId,
    Long doorId
  ) throws CustomerNotFoundException, DoorNotFoundException, AccessNotFoundException {
    GetCustomerResponse customerResponse = customerClient.getById(customerId);
    GetDoorResponse doorResponse = doorClient.getById(doorId);
    Access access = repository.getByCustomerIdAndDoorId(customerId, doorId)
      .orElseThrow(AccessNotFoundException::new);

    AccessLog log = new AccessLog();
    log.setCustomerId(access.getCustomerId());
    log.setDoorId(access.getDoorId());
    log.setAuthorized(isCustomerAuthorized());
    accessProducer.publish(log);

    return access;
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

  private Boolean isCustomerAuthorized() {
    Random random = new Random();
    return random.nextBoolean();
  }
}
