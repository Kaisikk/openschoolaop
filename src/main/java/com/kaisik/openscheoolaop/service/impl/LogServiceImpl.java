package com.kaisik.openscheoolaop.service.impl;

import com.kaisik.openscheoolaop.model.entity.EntityLog;
import com.kaisik.openscheoolaop.model.entity.enums.LogType;
import com.kaisik.openscheoolaop.model.repo.LogRepository;
import com.kaisik.openscheoolaop.service.intr.LogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LogServiceImpl implements LogService {

    LogRepository logRepository;

    @Override
    public void addLogToDb(EntityLog log) {
        logRepository.save(log);
    }

    @Override
    public void addMessageToDb(String message) {
        EntityLog log =
                new EntityLog(
                        UUID.randomUUID(),
                        LogType.INFO,
                        new Date(),
                        null,
                        message,
                        null);
        logRepository.save(log);

    }

    @Override
    public EntityLog getLog(UUID id) {
        return logRepository.findById(id).get();
    }

    @Override
    public List<EntityLog> getLogsByMethodName(String methodName) {
        return logRepository.findByMethodName(methodName);
    }

    @Override
    public long getTimeStatisticByMethod(String methodName) {
        List<EntityLog> logs = getLogsByMethodName(methodName);
        long sum = logs.stream()
                .filter(log -> log.getWastedTime() != null)
                .mapToLong(EntityLog::getWastedTime)
                .sum();
        if(sum == 0){
            return sum;
        } else {
            return sum / logs.size();
        }
    }
}
