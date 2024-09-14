package com.kaisik.openscheoolaop.service.impl;

import com.kaisik.openscheoolaop.service.intr.StartWorkService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StartWorkServiceImpl implements StartWorkService {

    /**
     * Запуск какой-то работы
     *
     * @throws InterruptedException
     */
    @Override
    public void startWork() throws InterruptedException {
    int wastedTime = getWastedTime();
    if(wastedTime < 5000){
        doUsefulWork(wastedTime);
    } else {
        doErrorWork(wastedTime);
    }
    }


    /**
     * Запуск какой-то бесполезной работы
     *
     * @param wastedTime Время на работу
     * @throws InterruptedException
     */
    private void doUsefulWork(long wastedTime) throws InterruptedException {
        System.out.println("Запуск какой-то полезной работы работы");
        Thread.sleep(wastedTime);
        System.out.println("Работа закончена");
    }

    /**
     * Запуск работы, которая упадет с ошибкой
     *
     * @param wastedTime Время затраченное на работу
     * @throws InterruptedException
     */
    private void doErrorWork(long wastedTime) throws InterruptedException {
        System.out.println("Запуск какой-то работы и падение с ошибкой");
        Thread.sleep(wastedTime);
        throw new RuntimeException("Произошла ошибка во время работы метода");
    }

    /**
     * Получение рандомного числа которое будем тратить на работу
     *
     * @return Время потраченное на работу
     */
    private int getWastedTime(){
        Random random = new Random();
        int min = 1000;
        int max = 10000;
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }

}
