package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LogTime.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final double f18069a = 1.0d / Math.pow(10.0d, 6.0d);

    private f() {
    }

    public static double a(long j4) {
        double b4 = b() - j4;
        double d4 = f18069a;
        Double.isNaN(b4);
        return b4 * d4;
    }

    @TargetApi(17)
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
