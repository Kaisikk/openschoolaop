package com.kaisik.openscheoolaop.aspect;

import com.kaisik.openscheoolaop.model.entity.EntityLog;
import com.kaisik.openscheoolaop.model.entity.enums.LogType;
import com.kaisik.openscheoolaop.service.intr.LogService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Aspect
@Component
@AllArgsConstructor
public class WorkTimeAspect {

    private LogService logService;

    @SneakyThrows
    @Around("within(com.kaisik.openscheoolaop.service.impl.StartWorkServiceImpl)")
    public Object beforeAnyMethod(ProceedingJoinPoint joinPoint) {
    long startTime = System.currentTimeMillis();
    Long workTime = null;
    Object res = null;
        try {
             res = joinPoint.proceed();
        } catch (Throwable e) {
            workTime = System.currentTimeMillis() - startTime;
            logService.addLogToDb(new EntityLog(
                    UUID.randomUUID(),
                    LogType.ERROR,
                    new Date(),
                    joinPoint.getSignature().getName() + "(" + joinPoint.getSignature().getDeclaringTypeName()  + ")",
                    e.getMessage(),
                    workTime));
            throw e;
        }
        workTime = System.currentTimeMillis() - startTime;
        logService.addLogToDb(new EntityLog(
                UUID.randomUUID(),
                LogType.STATISTIC,
                new Date(),
                joinPoint.getKind() + "(" + joinPoint.getSignature() + ")",
                null,
                workTime));
        return  res;
    }

}
