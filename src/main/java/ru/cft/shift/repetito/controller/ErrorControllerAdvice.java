package ru.cft.shift.repetito.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.cft.shift.repetito.exception.AccessIsForbiddenException;
import ru.cft.shift.repetito.exception.NotAuthorisedException;
import ru.cft.shift.repetito.exception.ResourceIsNotFoundException;


@ControllerAdvice
public class ErrorControllerAdvice {
    private final static Logger logger = LoggerFactory.getLogger(ErrorControllerAdvice.class);
    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception e) {
        logger.error(e.getMessage(), e);
        /*ResultResponse resultResponse = new ResultResponse();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseCode.ERROR.getCode());
        responseStatus.setErrorMessage("Сервис временно недоступен. Попробуйте позже.");
        resultResponse.setStatus(responseStatus);*/
        if (e instanceof ResourceIsNotFoundException){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource is not found");
        }
        else if (e instanceof AccessIsForbiddenException){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access is forbidden");
        }
        else if (e instanceof NotAuthorisedException){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not authorised");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Server error");

    }
}
