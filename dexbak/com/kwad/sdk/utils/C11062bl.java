package com.kwad.sdk.utils;

import com.kwad.sdk.core.p397e.C10331c;
import java.util.Formatter;
import java.util.Locale;

/* renamed from: com.kwad.sdk.utils.bl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11062bl {
    /* renamed from: ab */
    public static String m23867ab(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        try {
            long j2 = j / 1000;
            long j3 = j2 % 60;
            long j4 = (j2 / 60) % 60;
            long j5 = j2 / 3600;
            Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
            return j5 > 0 ? formatter.format("%d:%02d:%02d", Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)).toString() : formatter.format("%02d:%02d", Long.valueOf(j4), Long.valueOf(j3)).toString();
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            return "";
        }
    }
}
