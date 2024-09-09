package com.kwad.components.core.s;

import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    public static String a(long j4, boolean z3) {
        double d4;
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j4 <= 1) {
            return j4 + "B";
        }
        double d5 = j4;
        int log = (int) (Math.log(d5) / Math.log(1024.0d));
        if (j4 > 1024) {
            double pow = Math.pow(1024.0d, log);
            Double.isNaN(d5);
            d4 = d5 / pow;
        } else {
            Double.isNaN(d5);
            d4 = d5 / 1024.0d;
        }
        return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(d4), strArr[log]);
    }
}
