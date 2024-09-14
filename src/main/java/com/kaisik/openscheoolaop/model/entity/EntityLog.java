package com.kaisik.openscheoolaop.model.entity;

import com.kaisik.openscheoolaop.model.entity.enums.LogType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * Entity класс для записи логов в базу
 */
@Entity
@Table(name = "LOG")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Тип лога
     */
    private LogType type;

    /**
     * Дата создания лога
     */
    private Date createdDate;

    /**
     * Название метода (с сигнатурой)
     */
    private String method;

    /**
     * Сообщение лога
     */
    private String message;

    /**
     * Время работы метода
     */
    private Long wastedTime;

}
