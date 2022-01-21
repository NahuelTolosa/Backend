package com.app.app.handle;

import org.apache.logging.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ErrorHandle extends ResponseEntityExceptionHandler {

    Logger logger = LogManager.getLogger(ErrorHandle.class);

    @ResponseBody
    @ExceptionHandler
    public ErrorMessage messageErrorHandle(AppException ex) {
        return buildResponse(ex);
    }

    @ResponseBody
    @ExceptionHandler
    public ErrorMessage messageErrorHandle(NoSuchElementException ex) {
        return buildResponse(ex);
    }

    private ErrorMessage buildResponse(Exception ex) {
        logger.error(ex);
        return new ErrorMessage(ex.getMessage());
    }


}
