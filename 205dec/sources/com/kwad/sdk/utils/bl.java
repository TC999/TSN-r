package com.kwad.sdk.utils;

import java.util.Formatter;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bl {
    public static String ab(long j4) {
        if (j4 <= 0 || j4 >= 86400000) {
            return "00:00";
        }
        try {
            long j5 = j4 / 1000;
            long j6 = j5 % 60;
            long j7 = (j5 / 60) % 60;
            long j8 = j5 / 3600;
            Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
            return j8 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j8), Long.valueOf(j7), Long.valueOf(j6)).toString() : formatter.format("%02d:%02d", Long.valueOf(j7), Long.valueOf(j6)).toString();
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            return "";
        }
    }
}
