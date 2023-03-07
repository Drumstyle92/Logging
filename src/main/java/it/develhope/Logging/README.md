# Exercise - Spring Boot - logging
* write a Spring Boot application with the necessary dependencies that:
    * has two custom int environment variables with the values `2` and `8`
    * starts from `INFO` for root level logging
    * starts from `DEBUG` for services level logging
    * the logging info has ANSI colours enabled
    * has a basic controller that has 3 mappings:
        * `/`: returns just a welcome message and logs it
        * `/exp`: returns a service that:
            * takes the 2 numeric env values, then logs and returns the power (exponent) of the 2 values
            * logs when starting and when finishing the calculation
        * `/get-errors`: throws a new custom error that will be logged
    * saves all the logs in a subfolder called `myCustomLogs`


![](Logging.PNG)