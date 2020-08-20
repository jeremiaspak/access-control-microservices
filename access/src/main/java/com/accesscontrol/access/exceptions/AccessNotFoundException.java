package com.accesscontrol.access.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Access not found")
public class AccessNotFoundException extends RuntimeException { }
