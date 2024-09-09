package com.qq.e.comm.plugin.util;

import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class v1 {
    public static String a(long j4) {
        if (j4 > 1048576) {
            return c(j4);
        }
        return b(j4);
    }

    public static String b(long j4) {
        return String.format(Locale.ENGLISH, "%.2f K", Float.valueOf(((float) j4) / 1024.0f));
    }

    public static String c(long j4) {
        return String.format(Locale.ENGLISH, "%.2f M", Float.valueOf(((float) j4) / 1048576.0f));
    }
}
