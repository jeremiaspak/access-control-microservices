package com.accesscontrol.door.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CreateDoorRequest {

  @NotBlank
  @JsonProperty("andar")
  private String floor;

  @NotBlank
  @JsonProperty("sala")
  private String room;

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
