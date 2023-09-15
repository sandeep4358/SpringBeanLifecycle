package com.javafruit.LifecycleTest.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DataBaseConnection {
    public DataBaseConnection(){
        log.info("jdbc connection..constructor called.");
    }
}
