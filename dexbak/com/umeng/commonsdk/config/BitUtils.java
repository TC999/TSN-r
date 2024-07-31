package com.umeng.commonsdk.config;

/* renamed from: com.umeng.commonsdk.config.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BitUtils {
    /* renamed from: a */
    public static boolean m14030a(int i, int i2) {
        return i2 >= 0 && i2 <= 31 && (i & (1 << i2)) != 0;
    }

    /* renamed from: a */
    public static boolean m14029a(long j, int i) {
        return i >= 0 && i <= 63 && (j & (1 << i)) != 0;
    }

    /* renamed from: b */
    public static int m14028b(int i, int i2) {
        return i | (1 << i2);
    }

    /* renamed from: b */
    public static long m14027b(long j, int i) {
        return (i < 0 || i > 63) ? j : j | (1 << i);
    }

    /* renamed from: c */
    public static int m14026c(int i, int i2) {
        return i & ((1 << i2) ^ (-1));
    }

    /* renamed from: c */
    public static long m14025c(long j, int i) {
        return (i < 0 || i > 63) ? j : j & ((1 << i) ^ (-1));
    }
}
