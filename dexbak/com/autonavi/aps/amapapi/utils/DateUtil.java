package com.autonavi.aps.amapapi.utils;

import java.util.Calendar;
import java.util.Date;

/* renamed from: com.autonavi.aps.amapapi.utils.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DateUtil {
    /* renamed from: a */
    public static long m51287a(long j, long j2, int i) {
        if (i > 0) {
            try {
                return Math.abs(j - j2) > ((long) i) * 31536000000L ? m51288a(j, j2) : j;
            } catch (Throwable unused) {
                return j;
            }
        }
        return j;
    }

    /* renamed from: b */
    private static long m51286b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* renamed from: a */
    private static long m51288a(long j, long j2) {
        long m51286b = m51286b(j2) + m51289a(j);
        long abs = Math.abs(m51286b - j2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(m51286b));
        int i = calendar.get(11);
        if (i == 23 && abs >= 82800000) {
            m51286b -= 86400000;
        }
        return (i != 0 || abs < 82800000) ? m51286b : m51286b + 86400000;
    }

    /* renamed from: a */
    private static long m51289a(long j) {
        return j - m51286b(j);
    }
}
