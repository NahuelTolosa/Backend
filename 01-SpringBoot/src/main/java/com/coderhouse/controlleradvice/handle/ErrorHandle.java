package com.coderhouse.controlleradvice.handle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandle {

    Logger logger = LogManager.getLogger(ErrorHandle.class);

    @ResponseBody
    @ExceptionHandler(FirstApplicationException.class)

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage messageErrorHandle(FirstApplicationException ex) {
        logger.error(ex);
        return new ErrorMessage(ex.getMessage());
    }


}
