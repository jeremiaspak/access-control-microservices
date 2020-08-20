package com.accesscontrol.access.model;

public class AccessLog {

  private Long customerId;

  private Long doorId;

  private Boolean isAuthorized;

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

  public Boolean getAuthorized() {
    return isAuthorized;
  }

  public void setAuthorized(Boolean authorized) {
    isAuthorized = authorized;
  }
}
