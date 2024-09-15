package com.kaisik.openscheoolaop.service.intr;

import com.kaisik.openscheoolaop.model.entity.EntityLog;
import com.kaisik.openscheoolaop.model.entity.enums.LogType;


import java.util.List;
import java.util.UUID;

public interface LogService {

    /**
     * Добавление лога в бд
     *
     * @param log
     */
    void addLogToDb(EntityLog log);

    /**
     * Добавление сообщения лога в бд с типом INFO
     *
     * @param message
     */
    void addMessageToDb(String message);

    /**
     * Получение лога по id
     *
     * @param id
     * @return
     */
    EntityLog getLog(UUID id);

    /**
     * получение логов по названию метода и типу лога
     *
     * @param methodName
     * @param type
     * @return
     */
    List<EntityLog> getLogsByMethodNameAndType(String methodName, LogType type);

}
