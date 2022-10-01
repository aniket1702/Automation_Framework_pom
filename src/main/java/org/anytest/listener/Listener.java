package org.anytest.listener;

import org.anytest.logger.Framework_Logger;
import org.anytest.logger.LogManager;
import org.anytest.logger.enums.LogType;
import org.testng.*;

public class Listener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite)
    {
        LogManager.propertyConfigurator();
    }

    @Override
    public void onFinish(ISuite suite) {
      //not implemented
    }

    @Override
    public void onTestStart(ITestResult result) {
        Framework_Logger.log(LogType.PASS,result.getMethod().getTestClass().getName()+" - " +result.getMethod().getMethodName()+" started...");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Framework_Logger.log(LogType.PASS, result.getMethod().getTestClass().getName()+" - " +result.getMethod().getMethodName()+" is PASSED...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Framework_Logger.log(LogType.FAIL, result.getMethod().getTestClass().getName()+" - " +result.getMethod().getMethodName()+" is FAILED...");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Framework_Logger.log(LogType.SKIP,result.getMethod().getTestClass().getName()+" - " +result.getMethod().getMethodName()+" is SKIPPED...");
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
        Framework_Logger.log(LogType.FATAL,"======================== onStart :-" + context.getName() + "========================");
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
        Framework_Logger.log(LogType.FATAL,"======================== onFinish :-" + context.getName() + "========================");

    }
}
