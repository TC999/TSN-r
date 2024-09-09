package com.facebook.rebound;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class SpringUtil {
    public static double a(double d4, double d5, double d6) {
        return Math.min(Math.max(d4, d5), d6);
    }

    public static double b(double d4, double d5, double d6, double d7, double d8) {
        return d7 + (((d4 - d5) / (d6 - d5)) * (d8 - d7));
    }
}
