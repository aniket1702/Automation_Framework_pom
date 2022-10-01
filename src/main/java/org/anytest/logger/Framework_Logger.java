package org.anytest.logger;

import org.anytest.logger.enums.LogType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public final class Framework_Logger {

    private Framework_Logger()
    {
    }

    private static final Consumer<String> PASS= LogManager::info;
    private static final Consumer<String> FAIL= LogManager::error;
    private static final Consumer<String> SKIP= LogManager::warn;
    private static final Consumer<String> TRACE= LogManager::trace;
    private static final Consumer<String> FATAL= LogManager::fatal;




    private static final Map<LogType,Consumer<String>> MAP=new EnumMap<>(LogType.class);

    static {
        MAP.put(LogType.PASS, PASS);
        MAP.put(LogType.FAIL, FAIL);
        MAP.put(LogType.SKIP, SKIP);
        MAP.put(LogType.FATAL, FATAL);
        MAP.put(LogType.TRACE, TRACE);
    }

    public static void log(LogType status, String message) {
        MAP.get(status).accept(message);
    }
}
