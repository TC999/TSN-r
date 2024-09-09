package com.bytedance.msdk.core.gd;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {
    public static long c(long j4) {
        Date date;
        Date date2 = new Date();
        int minutes = date2.getMinutes();
        if (j4 >= 3600000) {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 0, 0);
        } else if (minutes <= 30) {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 0, 0);
        } else {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 30, 0);
        }
        return c(date.getTime(), j4);
    }

    public static String w(long j4) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j4));
    }

    private static long c(long j4, long j5) {
        Date date = new Date(j5 + j4);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK_IntervalEffectiveTime", "old time " + j4 + " new time = " + simpleDateFormat.format(date) + " \u6beb\u79d2 = " + time);
        return time;
    }
}
