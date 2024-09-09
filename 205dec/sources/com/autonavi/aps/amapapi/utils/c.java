package com.autonavi.aps.amapapi.utils;

import java.util.Calendar;
import java.util.Date;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DateUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c {
    public static long a(long j4, long j5, int i4) {
        if (i4 > 0) {
            try {
                return Math.abs(j4 - j5) > ((long) i4) * 31536000000L ? a(j4, j5) : j4;
            } catch (Throwable unused) {
                return j4;
            }
        }
        return j4;
    }

    private static long b(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static long a(long j4, long j5) {
        long b4 = b(j5) + a(j4);
        long abs = Math.abs(b4 - j5);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(b4));
        int i4 = calendar.get(11);
        if (i4 == 23 && abs >= 82800000) {
            b4 -= 86400000;
        }
        return (i4 != 0 || abs < 82800000) ? b4 : b4 + 86400000;
    }

    private static long a(long j4) {
        return j4 - b(j4);
    }
}
