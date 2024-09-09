package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d2 {
    public static boolean a(List<i1> list) {
        boolean z3;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
        int i4 = calendar.get(11);
        int i5 = calendar.get(12);
        int i6 = (i4 * 60) + i5;
        d1.a("current time: hour = %d, minute = %d, timeByMinute = %d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
        Iterator<i1> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z3 = false;
                break;
            } else if (it.next().a(Integer.valueOf(i6))) {
                z3 = true;
                break;
            }
        }
        d1.a("isInTimeRange %b", Boolean.valueOf(z3));
        return z3;
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            String[] split = str.split(":");
            if (split.length == 2) {
                return (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
            }
        } catch (Exception e4) {
            d1.a("hour2minute", e4);
        }
        return -1;
    }

    public static List<i1> a(String str) {
        String[] split;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null && split.length > 0) {
            for (String str2 : split) {
                String[] split2 = str2.split("-");
                if (split2.length == 2) {
                    try {
                        i1 a4 = i1.a(Integer.valueOf(b(split2[0])), Integer.valueOf(b(split2[1])));
                        d1.a("affect range " + a4, new Object[0]);
                        arrayList.add(a4);
                    } catch (Exception e4) {
                        d1.a("parse range error", e4);
                    }
                }
            }
        }
        return arrayList;
    }

    public static long a(int i4) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(5, i4);
        return calendar.getTimeInMillis();
    }

    public static int a() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(11) * 60) + calendar.get(12);
    }
}
