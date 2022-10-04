package org.anytest.logger;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.anytest.extentreport.ExtentReportManager;
import org.anytest.logger.enums.LogType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

public final class Framework_Logger {

    private Framework_Logger()
    {
    }

    /* LOGS MESSAGES ONLY TO LOG FILES */
    private static final Consumer<String> PASS= LogManager::info;
    private static final Consumer<String> FAIL= LogManager::error;
    private static final Consumer<String> SKIP= LogManager::warn;
    private static final Consumer<String> TRACE= LogManager::trace;
    private static final Consumer<String> FATAL= LogManager::fatal;


    /* LOGS MESSAGES ONLY TO EXTENT REPORT */
    private static final Consumer<String> PASS_EXTENT= message->ExtentReportManager.getExtentTest().pass(message);
    private static final Consumer<String> FAIL_EXTENT= message->ExtentReportManager.getExtentTest().fail(message);
    private static final Consumer<String> SKIP_EXTENT= message->ExtentReportManager.getExtentTest().skip(message);
    private static final Consumer<String> INFO_EXTENT= message->ExtentReportManager.getExtentTest().info(message);

    /* LOGS MESSAGES TO CONSOLE AND EXTENT REPORT */
    private static final Consumer<String> PASS_EXTENT_AND_LOG= PASS_EXTENT.andThen(PASS);
    private static final Consumer<String> FAIL_EXTENT_AND_LOG= FAIL_EXTENT.andThen(FAIL);
    private static final Consumer<String> SKIP_EXTENT_AND_LOG= SKIP_EXTENT.andThen(SKIP);
    private static final Consumer<String> INFO_EXTENT_AND_LOG= INFO_EXTENT.andThen(PASS);


    /* LOGS MESSAGES TO ONLY EXTENT REPORT WITH LABELS */
    private static final Consumer<String> PASS_EXTENT_WITH_LABEL= message->ExtentReportManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
    private static final Consumer<String> FAIL_EXTENT_WITH_LABEL= message->ExtentReportManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
    private static final Consumer<String> SKIP_EXTENT_WITH_LABEL= message->ExtentReportManager.getExtentTest().skip(MarkupHelper.createLabel(message, ExtentColor.ORANGE));
    private static final Consumer<String> INFO_EXTENT_WITH_LABEL= message->ExtentReportManager.getExtentTest().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));

    /* LOGS MESSAGES TO EXTENT REPORT AND LOG FILES WITH LABELS */
    private static final Consumer<String> PASS_EXTENT_AND_LOG_WITH_LABEL= PASS_EXTENT_WITH_LABEL.andThen(PASS);
    private static final Consumer<String> FAIL_EXTENT_AND_LOG_WITH_LABEL= FAIL_EXTENT_WITH_LABEL.andThen(FAIL);
    private static final Consumer<String> SKIP_EXTENT_AND_LOG_WITH_LABEL= SKIP_EXTENT_WITH_LABEL.andThen(SKIP);
    private static final Consumer<String> INFO_EXTENT_AND_LOG_WITH_LABEL= INFO_EXTENT_WITH_LABEL.andThen(PASS);



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

        MAP.put(LogType.PASS_EXTENT_WITH_LABEL, PASS_EXTENT_AND_LOG_WITH_LABEL);
        MAP.put(LogType.FAIL_EXTENT_WITH_LABEL, FAIL_EXTENT_AND_LOG_WITH_LABEL);
        MAP.put(LogType.SKIP_EXTENT_WITH_LABEL, SKIP_EXTENT_AND_LOG_WITH_LABEL);
        MAP.put(LogType.INFO_EXTENT_WITH_LABEL, INFO_EXTENT_AND_LOG_WITH_LABEL);
    }

    public static void log(LogType status, String message) {
        MAP.get(status).accept(message);
    }
}
