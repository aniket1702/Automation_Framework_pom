package org.anytest.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogManager {


    private static final Logger LOGGER=Logger.getLogger(Framework_Logger.class);
    private static final String LOG4J_PATH=System.getProperty("user.dir")+"/src/main/resources/log4j/log4j.properties";


    private LogManager()
    {

    }

    public static void propertyConfigurator()
    {
        PropertyConfigurator.configure(LOG4J_PATH);
    }

    public static void info(String message)
    {
        LOGGER.info(message);
    }

    public static void trace(String message)
    {
        LOGGER.trace(message);
    }
    public static void warn(String message) { LOGGER.warn(message); }
    public static void error(String message)
    {
        LOGGER.error(message);
    }
    public static void fatal(String message)
    {
        LOGGER.fatal(message);
    }

}
