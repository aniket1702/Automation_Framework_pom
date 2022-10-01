package org.anytest.logger;

import com.aventstack.extentreports.model.Media;
import org.anytest.extentreport.ExtentReport;
import org.anytest.extentreport.ExtentReportManager;
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


    private static final Consumer<String> PASS_EXTENT= message->ExtentReportManager.getExtentTest().pass(message);
    private static final Consumer<String> FAIL_EXTENT= message->ExtentReportManager.getExtentTest().fail(message);
    private static final Consumer<String> SKIP_EXTENT= message->ExtentReportManager.getExtentTest().skip(message);
    private static final Consumer<String> INFO_EXTENT= message->ExtentReportManager.getExtentTest().info(message);

    private static final Consumer<String> PASS_EXTENT_AND_LOG= PASS_EXTENT.andThen(PASS);
    private static final Consumer<String> FAIL_EXTENT_AND_LOG= FAIL_EXTENT.andThen(FAIL);
    private static final Consumer<String> SKIP_EXTENT_AND_LOG= SKIP_EXTENT.andThen(SKIP);
    private static final Consumer<String> INFO_EXTENT_AND_LOG= INFO_EXTENT.andThen(PASS);


    private static final Map<LogType,Consumer<String>> MAP=new EnumMap<>(LogType.class);

    static {
        MAP.put(LogType.PASS, PASS);
        MAP.put(LogType.FAIL, FAIL);
        MAP.put(LogType.SKIP, SKIP);
        MAP.put(LogType.FATAL, FATAL);
        MAP.put(LogType.TRACE, TRACE);

        MAP.put(LogType.PASS_EXTENT_AND_LOG, PASS_EXTENT_AND_LOG);
        MAP.put(LogType.FAIL_EXTENT_AND_LOG, FAIL_EXTENT_AND_LOG);
        MAP.put(LogType.SKIP_EXTENT_AND_LOG, SKIP_EXTENT_AND_LOG);
        MAP.put(LogType.INFO_EXTENT_AND_LOG, INFO_EXTENT_AND_LOG);
    }

    public static void log(LogType status, String message) {
        MAP.get(status).accept(message);
    }
}
