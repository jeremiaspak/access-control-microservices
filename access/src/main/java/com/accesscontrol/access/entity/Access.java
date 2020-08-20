package com.accesscontrol.access.entity;

import javax.persistence.*;

@Entity
public class Access {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private Long customerId;

  @Column
  private Long doorId;;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
