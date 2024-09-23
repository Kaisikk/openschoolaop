package com.kaisik.openscheoolaop.api.controller;

import com.kaisik.openscheoolaop.model.entity.EntityLog;
import com.kaisik.openscheoolaop.model.entity.enums.LogType;
import com.kaisik.openscheoolaop.service.intr.LogService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/admin/logs")
@AllArgsConstructor
public class LogController {

    LogService logService;

    /**
     * Контроллер чтобы получить статистику по названию метода и типу лога
     *
     * @param methodName
     * @param type
     * @return List
     */
    @GetMapping
    @Tag(name = "Статистика по названию метода", description = "Статистика по названию метода и типу статистики")
    public List<EntityLog> getStatisticByMethod(
            @RequestParam(name = "method") @Parameter(description = "Название метода по которому хотим получить статистику") String methodName,
            @RequestParam("type") @Parameter(description = "Тип лога") LogType type) {

        if (methodName == null) {
            throw new NoSuchElementException("Не передано имя метода");
        }

        if (type == null) {
            throw new NoSuchElementException("Не передан тип лога");
        }

        return logService.getLogsByMethodNameAndType(methodName, type);
    }

}
