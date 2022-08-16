package com.freshbeauty.controllers;

import com.freshbeauty.exceptions.DatabaseFetchException;
import com.freshbeauty.utils.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * @author Yuliana
 * @version 1.0.0
 * @project FreshBeauty
 * @class GlobalExceptionHandler
 * @since 8/13/2022 - 19.59
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DatabaseFetchException.class)
    public ResponseEntity<ErrorMessage> handleDatabaseFetchException(DatabaseFetchException ex, WebRequest request) {
        LOGGER.error("Could not fetch data from database", ex);
        return getResponse(HttpStatus.NOT_FOUND, request, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception ex, WebRequest request) {
        LOGGER.error("Got unknown error", ex);
        return getResponse(HttpStatus.INTERNAL_SERVER_ERROR, request, ex.getMessage());
    }

    private ResponseEntity<ErrorMessage> getResponse(HttpStatus status, WebRequest request, String message) {
        String path = ((ServletWebRequest)request).getRequest().getRequestURI();
        ErrorMessage errorMessage = new ErrorMessage(status.value(), status.getReasonPhrase(), LocalDateTime.now(), path, message);
        return new ResponseEntity<>(errorMessage, status);
    }
}
