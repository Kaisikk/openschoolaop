package com.kaisik.openscheoolaop.api.controller;

import com.kaisik.openscheoolaop.service.intr.StartWorkService;
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
    public ResponseEntity doWork(){
        try {
            startWorkService.startWork();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception exception){
            throw new RuntimeException("произошла ошибка в работе сайта");
        }
    }

}
