package com.app.app.interceptor;

import org.apache.logging.log4j.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterInterception {

    Logger logger = LogManager.getLogger(AfterInterception.class);

    @Pointcut("@annotation(com.app.app.annotation.ServiceMethodAnnotation)")
    void serviceMethods() {}

    @After("serviceMethods()")
    void afterServiceMethods() {
        logger.info("AFTER: update/delete.");
    }

    @Pointcut("execution(* com.app.app.controller.ClientController.updateClient(..))")
    void exception(){}

    @AfterThrowing("exception()")
    void afterException() {
        logger.error("AFTER: Se envió un id inválido para actualizar al cliente.");
    }
}
