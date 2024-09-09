package com.umeng.commonsdk.config;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BitUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public static boolean a(int i4, int i5) {
        return i5 >= 0 && i5 <= 31 && (i4 & (1 << i5)) != 0;
    }

    public static boolean a(long j4, int i4) {
        return i4 >= 0 && i4 <= 63 && (j4 & (1 << i4)) != 0;
    }

    public static int b(int i4, int i5) {
        return i4 | (1 << i5);
    }

    public static long b(long j4, int i4) {
        return (i4 < 0 || i4 > 63) ? j4 : j4 | (1 << i4);
    }

    public static int c(int i4, int i5) {
        return i4 & ((1 << i5) ^ (-1));
    }

    public static long c(long j4, int i4) {
        return (i4 < 0 || i4 > 63) ? j4 : j4 & ((1 << i4) ^ (-1));
    }
}
