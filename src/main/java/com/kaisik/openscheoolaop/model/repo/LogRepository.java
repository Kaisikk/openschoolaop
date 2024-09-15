package com.kaisik.openscheoolaop.model.repo;

import com.kaisik.openscheoolaop.model.entity.EntityLog;
import com.kaisik.openscheoolaop.model.entity.enums.LogType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LogRepository extends CrudRepository<EntityLog, UUID> {

    /**
     * Поучение статистики по названию метода
     *
     * @param methodName
     * @return Список логов
     */
    @Query(value = "select en from EntityLog en where en.method = :method")
    List<EntityLog> findByMethodName(@Param("method") String methodName);

    /**
     * Получение статистики по названию метода и типу лога
     *
     * @param methodName
     * @param type
     * @return Список логов
     */
    @Query(value = "select en from EntityLog en where en.method = :method and en.type = :type")
    List<EntityLog> findByMethodNameAndType(@Param("method") String methodName, @Param("type")LogType type);

}
