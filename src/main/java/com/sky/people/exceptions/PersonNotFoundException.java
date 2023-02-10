package com.sky.people.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Person not found with that ID")
public class PersonNotFoundException extends RuntimeException{



}
