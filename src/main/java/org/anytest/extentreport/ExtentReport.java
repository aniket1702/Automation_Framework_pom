package org.anytest.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.anytest.constants.Constants;
import org.anytest.utils.config.ConfigFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

public final class ExtentReport {
    private ExtentReport(){}

    private static ExtentReports extent;

    public static void initReport()
    {
        if (Objects.isNull(extent))
        {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(Constants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle(ConfigFactory.getConfig().websiteName());
            spark.config().setReportName(ConfigFactory.getConfig().websiteName());

            extent.setSystemInfo("OS",System.getProperty("os.name"));
            extent.setSystemInfo("OS Architecture",System.getProperty("os.arch"));
            extent.setSystemInfo("Java Version",System.getProperty("java.version"));
            extent.setSystemInfo("Java Home",System.getProperty("java.home"));
            extent.setSystemInfo("Username",System.getProperty("user.name"));
            extent.setSystemInfo("User Directory",System.getProperty("user.dir"));
            extent.setSystemInfo("Environment", ConfigFactory.getConfig().environment());

        }
    }

    public static void createTest(Method method)
    {
        String testCaseDesc=method.getAnnotation(Test.class).description();
        ExtentReportManager.setExtentTest(extent.createTest(testCaseDesc));
    }

    public static void flushReport() throws IOException {
        if(Objects.nonNull(extent)){
            extent.flush();
        }
        ExtentReportManager.unload();
        Desktop.getDesktop().browse(new File(Constants.getExtentReportFilePath()).toURI());
    }
}
