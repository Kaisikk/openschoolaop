package com.kaisik.openscheoolaop.model.repo;

import com.kaisik.openscheoolaop.model.entity.EntityLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LogRepository extends CrudRepository<EntityLog, UUID> {

    @Query(value = "select en from EntityLog en where en.method = :method")
    List<EntityLog> findByMethodName(@Param("method") String methodName);
}
