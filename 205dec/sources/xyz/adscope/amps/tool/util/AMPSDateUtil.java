package xyz.adscope.amps.tool.util;

import java.util.Calendar;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSDateUtil {
    public static long getTimeMillisBeforeDay(int i4) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.add(5, -i4);
            return calendar.getTimeInMillis();
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0L;
        }
    }
}
