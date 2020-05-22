package com.vikshen.sportservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class RestExceptionHandler{

    //HANDLE NOT FOUND EXCEPTION
    @ExceptionHandler
    public ResponseEntity<ApiError> handleException(NotFoundException ex){

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex);

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }


    //HANDLE VALIDATION EXCEPTION
    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> handleException(ConstraintViolationException ex){
        List<String> details = new ArrayList<>();
        for(ConstraintViolation error : ex.getConstraintViolations()) {
            details.add(error.getMessage());
        }
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
