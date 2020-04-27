package com.kindsonthegenius.productweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializationComponent {

    private final Logger logger = LoggerFactory.getLogger(InitializationComponent.class);

    @PostConstruct
    public void init(){
        logger.info("Start");
        logger.info("Doing Nothing...");
        logger.info("End");
    }
}
