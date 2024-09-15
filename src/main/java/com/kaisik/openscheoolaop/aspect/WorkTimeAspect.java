package com.kaisik.openscheoolaop.aspect;

import com.kaisik.openscheoolaop.model.entity.EntityLog;
import com.kaisik.openscheoolaop.model.entity.enums.LogType;
import com.kaisik.openscheoolaop.service.intr.LogService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Aspect
@Component
@AllArgsConstructor
public class WorkTimeAspect {

    private LogService logService;

    /**
     * Аспект срабатывает перед вызовом метода
     * Работает на 1 конкретный класс
     *
     * @param joinPoint
     * @return
     */
    @SneakyThrows
    @Around("within(com.kaisik.openscheoolaop.service.impl.StartWorkServiceImpl)")
    public Object beforeAnyMethod(ProceedingJoinPoint joinPoint) {
    long startTime = System.currentTimeMillis();
    Long workTime = null;
    Object res = null;

        try {
             res = joinPoint.proceed();
        } catch (Throwable e) {
            // при ошибке пишем в бд ошибку с типом ERROR
            workTime = System.currentTimeMillis() - startTime;
            logService.addLogToDb(new EntityLog(
                    UUID.randomUUID(),
                    LogType.ERROR,
                    new Date(),
                    joinPoint.getSignature().getName(),
                    e.getMessage(),
                    workTime));
            throw e;
        }
        // если ошибки не было, то пишем в бд время работы в миллисекундах
        workTime = System.currentTimeMillis() - startTime;
        logService.addLogToDb(new EntityLog(
                UUID.randomUUID(),
                LogType.STATISTIC,
                new Date(),
                joinPoint.getSignature().getName(),
                null,
                workTime));
        return  res;
    }

}
