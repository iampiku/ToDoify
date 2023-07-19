package com.todo.utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.todo.exception.TodoException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(TodoException.class)
    public ResponseEntity<String> todoExceptionHandler(TodoException exception) {
        ErrorInfo errorInfo = new ErrorInfo();

        errorInfo.setErrorMessage(exception.getMessage());
        errorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorInfo.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        ErrorInfo errorInfo = new ErrorInfo();

        errorInfo.setErrorMessage(exception.getMessage());
        errorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorInfo.setTimeStamp(LocalDateTime.now());

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
