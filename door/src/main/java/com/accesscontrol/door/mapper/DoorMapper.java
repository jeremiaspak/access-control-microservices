package com.accesscontrol.door.mapper;

import com.accesscontrol.door.dto.CreateDoorRequest;
import com.accesscontrol.door.dto.CreateDoorResponse;
import com.accesscontrol.door.dto.GetDoorResponse;
import com.accesscontrol.door.entity.Door;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoorMapper {

  DoorMapper INSTANCE = Mappers.getMapper(DoorMapper.class);

  GetDoorResponse doorToGetDoorResponse(Door door);
  Iterable<GetDoorResponse> doorToGetDoorResponse(Iterable<Door> doors);

  Door createDoorRequestToDoor(CreateDoorRequest doorRequest);
  CreateDoorResponse doorToCreateDoorResponse(Door door);
}
