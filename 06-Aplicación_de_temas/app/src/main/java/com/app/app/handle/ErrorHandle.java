package com.app.app.handle;

import org.apache.logging.log4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ErrorHandle {

    Logger logger = LogManager.getLogger(ErrorHandle.class);

    @ResponseBody
    @ExceptionHandler(AppException.class)

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage messageErrorHandle(AppException ex) {
        logger.error(ex);
        return new ErrorMessage(ex.getMessage());
    }


}
