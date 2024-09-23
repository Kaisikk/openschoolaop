package com.kaisik.openscheoolaop.api.controller;

import com.kaisik.openscheoolaop.service.intr.StartWorkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("api/simplecontroller")
@AllArgsConstructor
public class ExampleController {

    StartWorkService startWorkService;

    /**
     * Запуск какой-то работы на сервере
     *
     * @return Просто статус ответа
     */
    @GetMapping
    @Tag(name = "Запуск работы", description = "Запуск какой-то работы и падение с ошибкой (возможно)")
    public ResponseEntity doWork(){
        try {
            startWorkService.startWork();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
