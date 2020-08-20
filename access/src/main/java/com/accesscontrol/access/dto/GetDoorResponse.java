package com.accesscontrol.access.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetDoorResponse {

  private Long id;

  @JsonProperty("andar")
  private String floor;

  @JsonProperty("sala")
  private String room;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFloor() {
    return floor;
  }

  public void setFloor(String floor) {
    this.floor = floor;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }
}
