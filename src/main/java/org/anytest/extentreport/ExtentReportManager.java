package org.anytest.extentreport;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {
    private ExtentReportManager(){}

    private static final ThreadLocal<ExtentTest> EXTENT_TEST=new ThreadLocal<>();

    public static ExtentTest getExtentTest()
    {
        return EXTENT_TEST.get();
    }

    public static void setExtentTest(ExtentTest extentTest)
    {
            EXTENT_TEST.set(extentTest);
    }

    public static void unload()
    {
        EXTENT_TEST.remove();
    }
}
