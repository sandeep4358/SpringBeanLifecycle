package com.javafruit.LifecycleTest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
@Slf4j
public class PrototypeService {

    private String dateTime = LocalDateTime.now().toString();  // this will be initialized when the object is created.
    public String getMethod(){
     log.info("Has code for check :: "+ this.hashCode());
        return  dateTime;
    }
}
