package it.develhope.Logging.controllers;

import it.develhope.Logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Drumstyle92
 * Controller class to handle CRUD of calls
 */
@RestController
public class BasicController {

    /**
     * an instance of BasicService injected through the @Autowired annotation thanks to Spring Boot
     */
    @Autowired
    BasicService basicService;

    /**
     * Instance of the Logger class that is part of the SLF4J
     * logging framework and is used to record log messages in a Java application.
     */
    Logger logger = LoggerFactory.getLogger(BasicController.class);

    /**
     * @return returns a welcome string "Welcome visitor!"
     * if you respond to HTTP GET requests to the application's base address
     * Get method that sends an endpoint to the application's base address
     */
    @GetMapping("/")
    public String getWelcome(){

        String message = "Welcome visitor!";

        logger.info(message);

        return message;

    }

    /**
     * @return returns the result of the power()
     * method of a BasicService instance (injected via the @Autowired annotation)
     * Get method which retrieves the endpoint on the /exp address of the application
     */
    @GetMapping("/exp")
    public String exponent() {

        return basicService.power();

    }

    /**
     * @return Returns a RunTimeException error with a custom message
     * Get method that throws a RuntimeException with an "ERRORS!" and writes it to the error log using the logger.
     */
    @GetMapping("/get-errors")
    public String error() {

        String message = "ERRORS!";

        logger.error(message);

        throw new RuntimeException(message);

    }

}
