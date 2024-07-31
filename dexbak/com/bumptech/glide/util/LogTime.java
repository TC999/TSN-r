package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* renamed from: com.bumptech.glide.util.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LogTime {

    /* renamed from: a */
    private static final double f14551a = 1.0d / Math.pow(10.0d, 6.0d);

    private LogTime() {
    }

    /* renamed from: a */
    public static double m44412a(long j) {
        double m44411b = m44411b() - j;
        double d = f14551a;
        Double.isNaN(m44411b);
        return m44411b * d;
    }

    @TargetApi(17)
    /* renamed from: b */
    public static long m44411b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
