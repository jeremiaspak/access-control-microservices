package com.accesscontrol.access.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAccessResponse {

  @JsonProperty("cliente_id")
  private Long customerId;

  @JsonProperty("porta_id")
  private Long doorId;;

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Long getDoorId() {
    return doorId;
  }

  public void setDoorId(Long doorId) {
    this.doorId = doorId;
  }
}
