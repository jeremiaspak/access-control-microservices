package com.accesscontrol.access.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Door not found")
public class DoorNotFoundException extends RuntimeException { }
