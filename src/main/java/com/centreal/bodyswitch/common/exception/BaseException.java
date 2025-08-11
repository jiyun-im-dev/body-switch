package com.centreal.bodyswitch.common.exception;

import com.centreal.bodyswitch.common.response.ResponseCode;
import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {
	public abstract ResponseCode getResponseCode();

	public abstract HttpStatus getHttpStatus();
}
