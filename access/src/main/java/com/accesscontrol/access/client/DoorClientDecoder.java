package com.accesscontrol.access.client;

import com.accesscontrol.access.exceptions.DoorNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class DoorClientDecoder implements ErrorDecoder {

  private ErrorDecoder errorDecoder = new Default();

  @Override
  public Exception decode(String s, Response response) {
    if (response.status() == 404) {
      return new DoorNotFoundException();
    }

    return errorDecoder.decode(s, response);
  }
}
