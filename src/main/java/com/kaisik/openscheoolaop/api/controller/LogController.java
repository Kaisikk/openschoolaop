package com.kaisik.openscheoolaop.api.controller;

import com.kaisik.openscheoolaop.model.entity.EntityLog;
import com.kaisik.openscheoolaop.model.entity.enums.LogType;
import com.kaisik.openscheoolaop.service.intr.LogService;
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
     * @return
     */
    @GetMapping
    public List<EntityLog> getStatisticByMethod(@RequestParam(name = "method") String methodName, @RequestParam("type") LogType type) {

        if (methodName == null) {
            throw new NoSuchElementException("Не передано имя метода");
        }

        if (type == null) {
            throw new NoSuchElementException("Не передан тип лога");
        }

        return logService.getLogsByMethodNameAndType(methodName, type);
    }

}
