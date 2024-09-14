package com.kaisik.openscheoolaop.service.intr;

import com.kaisik.openscheoolaop.model.entity.EntityLog;


import java.util.List;
import java.util.UUID;

public interface LogService {

    void addLogToDb(EntityLog log);

    void addMessageToDb(String message);

    EntityLog getLog(UUID id);

    List<EntityLog> getLogsByMethodName(String methodName);

    long getTimeStatisticByMethod(String methodName);

}
