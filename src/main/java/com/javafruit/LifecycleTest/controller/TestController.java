package com.javafruit.LifecycleTest.controller;

import com.javafruit.LifecycleTest.component.RepoDaoLayer;
import com.javafruit.LifecycleTest.service.PrototypeService;
import com.javafruit.LifecycleTest.service.SingletonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@Slf4j
@AllArgsConstructor
public class TestController {

    private SingletonService singletonService;

    private ApplicationContext context;
    @PostMapping
    @RequestMapping(value = "/test1")
    public List<String> check() throws InterruptedException {
        log.info("service hash Code :: "+ singletonService.hashCode());
        String first = singletonService.getMethod();

        Thread.sleep(2000);

        String second = singletonService.getMethod();

        return Arrays.asList(first,second);
    }

    @PostMapping
    @RequestMapping(value = "/test2")
    public void test2(){
        log.info("test2 :: started :: ");
        RepoDaoLayer dao1 = context.getBean(RepoDaoLayer.class);
        log.info("**********dao2***************");
        log.info("RepoDaoLayer connection hash code"+ " :: "+dao1.hashCode());
        log.info("Child Database connection object hash code :: "+dao1.getJdbcConnection().hashCode());




        RepoDaoLayer dao2 = context.getBean(RepoDaoLayer.class);
        log.info("**********dao1***************");
        log.info("RepoDaoLayer  hash code"+ " :: "+dao2.hashCode());
        log.info("child Database connection object hash code :: "+dao2.getJdbcConnection().hashCode());

    }
}
