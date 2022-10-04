package org.anytest.constants;

import org.anytest.utils.config.ConfigFactory;
import org.anytest.utils.dateutils.DateUtils;


public final class Constants {
    private Constants(){}

    /* CONSTANTS DEFINED FOR GETTING FILES FROM RESOURCES FOLDER */
    private static final String BASE_PATH = System.getProperty("user.dir");
    private static final String EXTENT_REPORT_FOLDER_PATH = BASE_PATH + "/test-output/sparkReport/";
    private static String extentReportFilePath = "";
    private static final String EXTENT_REPORT_XML_PATH = BASE_PATH+"/src/main/resources/extent-reporter/extent-config.xml";

    /* METHOD TO CREATE EXTENT REPORT HTML FILE. CREATES NEW FOLDER WITH CURRENT DATE AND TIME IF OVERRIDE REPORT IS SELECTED AS NO. OTHERWISE, IT OVERRIDES THE REPORT.*/
    public static String getExtentReportFolderPath()
    {

        /* GETS THE CURRENT DATE AND TIME FROM DATEUTIL CLASS FROM UTIL PACKAGE */
        String newDateTimeFormat= DateUtils.getCurrentDateTime();

        return (ConfigFactory.getConfig().overrideReport().equalsIgnoreCase("no"))
                ? EXTENT_REPORT_FOLDER_PATH + newDateTimeFormat + "/spark_report.html"
                : EXTENT_REPORT_FOLDER_PATH + "spark_report.html";
    }


    /* METHOD TO RETURN EXTENT REPORT FILE PATH. */
    public static String getExtentReportFilePath() {
        if(extentReportFilePath.isEmpty())
        {
            extentReportFilePath=getExtentReportFolderPath();
        }
        return extentReportFilePath;
    }

    /* METHOD TO RETURN EXTENT REPORT XML CONFIG PATH */
    public static String getExtentReportXMLPath() {
        return EXTENT_REPORT_XML_PATH;
    }

}
