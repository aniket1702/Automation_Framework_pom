package org.anytest.utils.dateutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {
    private DateUtils()
    {

    }

    public static String getCurrentDateTime()
    {
        String timeInMillis= String.valueOf(System.currentTimeMillis());
        long x=Long.parseLong(timeInMillis);

        Date date=new Date(x);
        DateFormat formatter=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss_aa");
        String newDateTimeFormat=formatter.format(date);
        return newDateTimeFormat;


    }
}
