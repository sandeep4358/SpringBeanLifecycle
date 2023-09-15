package com.javafruit.LifecycleTest.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RepoDaoLayer {
    @Autowired
    private DataBaseConnection jdbcConnection;


}
