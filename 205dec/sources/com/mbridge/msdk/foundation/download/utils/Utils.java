package com.mbridge.msdk.foundation.download.utils;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class Utils {
    private Utils() {
    }

    public static int getDownloadRate(long j4, long j5) {
        if (j4 == 0 || j5 == 0) {
            return 0;
        }
        if (j4 == j5) {
            return 100;
        }
        double d4 = j5;
        Double.isNaN(d4);
        double d5 = j4;
        Double.isNaN(d5);
        return (int) (((d4 * 1.0d) / (d5 * 1.0d)) * 100.0d);
    }
}
