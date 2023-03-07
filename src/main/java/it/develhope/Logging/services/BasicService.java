package it.develhope.Logging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author Drumstyle92
 * the class which is annotated with "@Service"
 * to indicate that it is a Spring service class and is therefore managed by the Spring framework.
 */
@Service
public class BasicService {

    /**
     * The "Environment" class is used to read application properties
     * from properties files by automating it with the @Autowired annotation
     */
    @Autowired
    Environment environment;

    /**
     * Instance of the Logger class that is part of the SLF4J
     * logging framework and is used to record log messages in a Java application
     */
    Logger logger = LoggerFactory.getLogger(BasicService.class);


    /**
     * @return Returns the string with the result of the power, both on the console and on the browser
     * power method that reads two integer values from
     * the specified property files and then computes the power of the two numbers
     * In case of input errors, a debug error is logged
     */
    public String power() {

        String numberPower = null;

        try {

            int value1 = Integer.parseInt(environment.getProperty("customEnvs.n1"));

            int value2 = Integer.parseInt(environment.getProperty("customEnvs.n2"));

            logger.debug("Calculation start");

            int result = 1;

            for (int i = 0; i < value2; i++) {

                result *= value1;

            }

            numberPower = String.valueOf(result);

            logger.debug("Result: {}", numberPower);

        } catch (NumberFormatException ex) {

            logger.error("Invalid input: {}", ex.getMessage());

        } finally {

            logger.debug("End of calculation");

        }

        return numberPower;

    }

}