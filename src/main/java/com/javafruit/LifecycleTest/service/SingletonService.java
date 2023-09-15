package com.javafruit.LifecycleTest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonService {
    @Autowired
   private   PrototypeService prototypeService;

    @Autowired
   private  ApplicationContext context;
    public String getMethod(){
        //we can use the Application context method as well for the same process.
        //return context.getBean(PrototypeService.class).getMethod();
        return prototypeService.getMethod();
        //return getPrototypeService().getMethod();
    }


    /**
     *
     * @return
     * This is the another way, the method is actually override
     * by the spring and will return the protoptype bean.
     */
    @Lookup
    public PrototypeService getPrototypeService(){
        return null;
    }


}
