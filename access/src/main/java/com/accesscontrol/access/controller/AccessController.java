package com.accesscontrol.access.controller;

import com.accesscontrol.access.dto.CreateAccessRequest;
import com.accesscontrol.access.dto.CreateAccessResponse;
import com.accesscontrol.access.dto.GetAccessResponse;
import com.accesscontrol.access.entity.Access;
import com.accesscontrol.access.mapper.AccessMapper;
import com.accesscontrol.access.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/acesso")
public class AccessController {

  @Autowired
  private AccessService accessService;

  @GetMapping
  public Iterable<GetAccessResponse> findAll() {
    return AccessMapper.INSTANCE.accessToGetAccessResponse(
      accessService.findAll()
    );
  }

  @GetMapping("/{customerId}/{doorId}")
  public GetAccessResponse getByCustomerIdAndDoorId(
    @PathVariable Long customerId,
    @PathVariable Long doorId
  ) {
    return AccessMapper.INSTANCE.accessToGetAccessResponse(
      accessService.getByCustomerIdAndDoorId(customerId, doorId)
    );
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public CreateAccessResponse create(@Valid @RequestBody CreateAccessRequest accessRequest) {
    Access access = accessService.create(
      AccessMapper.INSTANCE.createAccessRequestToAccess(accessRequest)
    );
    return AccessMapper.INSTANCE.accessToCreateAccessResponse(access);
  }

  @DeleteMapping("/{customerId}/{doorId}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteByCustomerIdAndDoorId(
    @PathVariable Long customerId,
    @PathVariable Long doorId
  ) {
    accessService.deleteByCustomerIdAndDoorId(customerId, doorId);
  }
}
