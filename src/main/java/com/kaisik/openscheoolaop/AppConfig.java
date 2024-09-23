package com.kaisik.openscheoolaop;

import com.kaisik.openschoolstarter.service.impl.HttpRequestHandler;
import com.kaisik.openschoolstarter.service.impl.RequestHandlerImpl;
import com.kaisik.openschoolstarter.service.impl.ResponseHandlerImpl;
import com.kaisik.openschoolstarter.service.intr.RequestHandler;
import com.kaisik.openschoolstarter.service.intr.ResponseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    /**
     * Настройка перехватчика запросов
     *
     * @return HttpRequestHandler
     */
    @Bean
    HttpRequestHandler httpRequestHandler() {
        HttpRequestHandler handler = new HttpRequestHandler(requestHandler(), responseHandler());
        // логировать хэдеры
        handler.setLogHeaders(true);
        // логировать тело входящего запроса
        handler.setLogRequestBody(true);
        // логировать время выполнения
        handler.setLogResponseTime(true);
        return handler;
    }

    /**
     * Обработчик входящих запросов (можно реализовать свой)
     *
     * @return RequestHandler
     */
    @Bean
    RequestHandler requestHandler() {
        return new RequestHandlerImpl();
    }

    /**
     * Обработчик ответов (можно реализовать свой)
     *
     * @return ResponseHandler
     */
    @Bean
    ResponseHandler responseHandler() {
        return new ResponseHandlerImpl();
    }

    /**
     * Конфиг для перехватчика запросов (перехватывает все запросы отправленные по переданному паттерну)
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpRequestHandler()).addPathPatterns("/api/**");
    }

}
