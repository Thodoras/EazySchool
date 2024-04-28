package org.thodoras.eazyschool.helpers.aspects.implementations;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LogAspectImpl {

    @Around("@annotation(org.thodoras.eazyschool.helpers.aspects.interfaces.LogAspect)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature().toString() + "method execution started");
        var start = Instant.now();
        var returnObj = joinPoint.proceed();
        var finish = Instant.now();
        var timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute " + joinPoint.getSignature().toString() + " method is : " + timeElapsed);
        log.info(joinPoint.getSignature().toString() + " method execution ended");
        return returnObj;
    }

    @AfterThrowing(value = "@annotation(org.thodoras.eazyschool.helpers.aspects.interfaces.LogExceptionAspect)", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.error(joinPoint.getSignature() + " An exception happened due to : " + ex.getMessage());
    }
}
