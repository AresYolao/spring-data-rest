package com.bandicoot.polar.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.bandicoot.polar.error.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class MyExceptionGlobalHandler {



    @ExceptionHandler(DataAccessException.class)
    protected ResponseEntity<Object> handleEntityNotFound(DataAccessException ex) {
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND, ex));
    }
	 
	    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
	    protected ResponseEntity<Object> handleConstraintViolation(
	            javax.validation.ConstraintViolationException ex) {

	    	 ErrorResponse apiError = new ErrorResponse(BAD_REQUEST);
	         apiError.setMessage("Validation error");
	         apiError.addValidationErrors(ex.getConstraintViolations());
	         return buildResponseEntity(apiError);
	    	

//	    	return new ResponseEntity( "constraint  " + ex.getMessage() + " " + ex.getConstraintViolations(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
	    }

	    
	    
	    @ExceptionHandler(DataIntegrityViolationException.class)
	    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex,
	                                                                  WebRequest request) {
	        if (ex.getCause() instanceof ConstraintViolationException) {
	            return buildResponseEntity(new ErrorResponse(HttpStatus.CONFLICT, "Database error", ex.getMostSpecificCause()));
	        }
	        
	        return buildResponseEntity(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex));
	    }
	    
	    
	    private ResponseEntity<Object> buildResponseEntity(ErrorResponse apiError) {
	        return new ResponseEntity<>(apiError, apiError.getStatus());
	    }
	    
	private String getJson(Object object) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException exception) {
			log.error("ERROR {}", exception);
		}
		return null;
	}

}
