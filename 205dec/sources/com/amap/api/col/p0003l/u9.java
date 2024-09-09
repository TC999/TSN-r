package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GeoUtil.java */
/* renamed from: com.amap.api.col.3l.u9  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u9 {
    public static double a(double d4, double d5, double d6, double d7) {
        double d8 = (((90.0d - d5) * 21412.0d) / 90.0d) + 6356725.0d;
        double cos = ((d6 * 0.01745329238474369d) - (d4 * 0.01745329238474369d)) * Math.cos((3.1415927410125732d * d5) / 180.0d) * d8;
        double d9 = ((d7 * 0.01745329238474369d) - (d5 * 0.01745329238474369d)) * d8;
        return Math.pow((cos * cos) + (d9 * d9), 0.5d);
    }
}
