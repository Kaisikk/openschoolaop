package com.kaisik.openscheoolaop.model.entity;

import com.kaisik.openscheoolaop.model.entity.enums.LogType;

import java.util.Date;
import java.util.UUID;

/**
 * Entity класс для записи логов в базу
 */
public class EntityLog {

    private UUID id;

    /**
     * Тип лога
     */
    private LogType type;

    /**
     * Дата создания лога
     */
    private Date createdDate;

    private String message;

}
