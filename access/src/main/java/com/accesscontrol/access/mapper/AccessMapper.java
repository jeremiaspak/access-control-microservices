package com.accesscontrol.access.mapper;

import com.accesscontrol.access.dto.CreateAccessRequest;
import com.accesscontrol.access.dto.CreateAccessResponse;
import com.accesscontrol.access.dto.GetAccessResponse;
import com.accesscontrol.access.entity.Access;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccessMapper {

  AccessMapper INSTANCE = Mappers.getMapper(AccessMapper.class);

  GetAccessResponse accessToGetAccessResponse(Access access);
  Iterable<GetAccessResponse> accessToGetAccessResponse(Iterable<Access> accesses);

  Access createAccessRequestToAccess(CreateAccessRequest accessRequest);
  CreateAccessResponse accessToCreateAccessResponse(Access access);
}
