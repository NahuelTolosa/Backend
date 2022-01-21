package com.app.app.interceptor;

import org.apache.logging.log4j.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class AroundInterception {

    Logger logger = LogManager.getLogger(AfterInterception.class);

    @Pointcut("execution(* com.app.app.service.ClientService.*(..)) &&" +
            "!execution(* com.app.app.service.ClientService.deleteClient(..))")
    void serviceMethods(){ }

    @Around("serviceMethods()")
        Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object ret = joinPoint.proceed();
        long end = System.nanoTime();

        logger.info("AROUND: Ejecución de método en Service (menos delete). Duración: {} ms", TimeUnit.NANOSECONDS.toMillis(end - start));
        return ret;
    }
}


