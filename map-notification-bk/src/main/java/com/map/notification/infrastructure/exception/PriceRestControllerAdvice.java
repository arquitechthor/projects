package com.map.notification.infrastructure.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class PriceRestControllerAdvice extends ResponseEntityExceptionHandler {

	  @ExceptionHandler(RecordNotFoundException.class)
	  @ResponseStatus(value = HttpStatus.NOT_FOUND)
	  public ErrorMessage resourceNotFoundException(RecordNotFoundException ex, WebRequest request) {
	    
		 ErrorMessage message = ErrorMessage.builder()
		    		.statusCode(HttpStatus.NOT_FOUND.value())
		    		.timestamp(LocalDateTime.now())
		    		.message("Record not found")
		    		.description(request.getDescription(false))
		    		.build();
		    
		 return message;
	  }
	  
	  @ExceptionHandler(Exception.class)
	  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
	    ErrorMessage message = ErrorMessage.builder()
	    		.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
	    		.timestamp(LocalDateTime.now())
	    		.message(ex.getMessage())
	    		.description(request.getDescription(false))
	    		.build();
	    
	    return message;
	  }
	  
}
