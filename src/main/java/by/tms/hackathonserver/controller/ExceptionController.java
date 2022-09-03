package by.tms.hackathonserver.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getFieldErrors();
        Map<String, String> mapina = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            mapina.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(mapina, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleMethodRuntimeException(RuntimeException runtimeException) {
        return new ResponseEntity<>(runtimeException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {

        return new ResponseEntity<>(constraintViolationException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
