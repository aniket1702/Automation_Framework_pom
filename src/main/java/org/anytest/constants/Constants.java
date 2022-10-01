package org.anytest.constants;

import org.anytest.utils.config.ConfigFactory;
import org.anytest.utils.dateutils.DateUtils;

public final class Constants {
    private Constants(){}

    private static final String BASE_PATH = System.getProperty("user.dir");
    private static final String EXTENT_REPORT_FOLDER_PATH = BASE_PATH + "/test-output/sparkReport/";
    private static String extentReportFilePath = "";

    public static String getExtentReportFolderPath()
    {

        String newDateTimeFormat= DateUtils.getCurrentDateTime();

        return (ConfigFactory.getConfig().overrideReport().equalsIgnoreCase("no"))
                ? EXTENT_REPORT_FOLDER_PATH + newDateTimeFormat + "/spark_report.html"
                : EXTENT_REPORT_FOLDER_PATH + "spark_report.html";
    }


    public static String getExtentReportFilePath() {
        if(extentReportFilePath.isEmpty())
        {
            extentReportFilePath=getExtentReportFolderPath();
        }
        return extentReportFilePath;
    }

}
