package org.anytest.listener;

import org.anytest.extentreport.ExtentReport;
import org.anytest.extentreport.ExtentReportManager;
import org.anytest.logger.Framework_Logger;
import org.anytest.logger.LogManager;
import org.anytest.logger.enums.LogType;
import org.testng.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class Listener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite)
    {
        try {
            ExtentReport.initReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LogManager.propertyConfigurator();
    }

    @Override
    public void onFinish(ISuite suite) {

        try {
            ExtentReport.flushReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getConstructorOrMethod().getMethod());
        Framework_Logger
                .log(LogType.PASS_EXTENT_WITH_LABEL,
                result
                        .getMethod()
                        .getTestClass()
                        .getName()
                        .substring(23)+" - " +result.getMethod().getMethodName()+" method started...");

    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        Framework_Logger
                .log(LogType.PASS_EXTENT_WITH_LABEL,
                        result
                                .getMethod()
                                .getTestClass()
                                .getName()
                                .substring(23) + " - " + result.getMethod().getMethodName() + " is PASSED...");

    }
    @Override
    public void onTestFailure(ITestResult result) {
        Framework_Logger
                .log(LogType.FAIL_EXTENT_WITH_LABEL,
                        result
                                .getMethod()
                                .getTestClass()
                                .getName()
                                .substring(23)+" - " +result.getMethod().getMethodName()+" is FAILED...");
       }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        Framework_Logger
                .log(LogType.SKIP_EXTENT_WITH_LABEL,
                        result
                                .getMethod()
                                .getTestClass()
                                .getName()
                                .substring(23)+" - " +result.getMethod().getMethodName()+" is SKIPPED...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    /**
     * Invoked each time a test fails due to a timeout.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     */
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    /**
     * Invoked before running all the test methods belonging to the classes inside
     * the &lt;test&gt; tag and calling all their Configuration methods.
     *
     * @param context The test context
     */
    @Override
    public void onStart(ITestContext context) {
        Framework_Logger.log(LogType.FATAL,"======================== Start :-" + context.getName() + "========================");
    }

    /**
     * Invoked after all the test methods belonging to the classes inside the
     * &lt;test&gt; tag have run and all their Configuration methods have been
     * called.
     *
     * @param context The test context
     */
    @Override
    public void onFinish(ITestContext context) {
        Framework_Logger.log(LogType.FATAL,"======================== Finish :-" + context.getName() + "========================");
    }
}
