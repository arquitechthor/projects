package com.map.notification.infrastructure.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public RecordNotFoundException() {
        super();
    }
    public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public RecordNotFoundException(String message) {
        super(message);
    }
    public RecordNotFoundException(Throwable cause) {
        super(cause);
    }
}