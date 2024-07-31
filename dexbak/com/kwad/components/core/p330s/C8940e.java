package com.kwad.components.core.p330s;

import java.util.Locale;

/* renamed from: com.kwad.components.core.s.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8940e {
    /* renamed from: a */
    public static String m29559a(long j, boolean z) {
        double d;
        String[] strArr = {" B", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB"};
        if (j <= 1) {
            return j + "B";
        }
        double d2 = j;
        int log = (int) (Math.log(d2) / Math.log(1024.0d));
        if (j > 1024) {
            double pow = Math.pow(1024.0d, log);
            Double.isNaN(d2);
            d = d2 / pow;
        } else {
            Double.isNaN(d2);
            d = d2 / 1024.0d;
        }
        return String.format(Locale.ENGLISH, "%.1f%s", Double.valueOf(d), strArr[log]);
    }
}
