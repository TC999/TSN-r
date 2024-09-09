package com.bytedance.sdk.openadsdk.core.s;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static boolean c(long j4) {
        return c(j4, c.USE_ALOG.c());
    }

    private static boolean c(long j4, long j5) {
        return (j4 & j5) == j5;
    }

    public static boolean w(long j4) {
        return c(j4, c.USE_PITAYA.c());
    }
}
