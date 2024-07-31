package com.mbridge.msdk.foundation.same.net;

import android.net.TrafficStats;
import android.os.SystemClock;

/* renamed from: com.mbridge.msdk.foundation.same.net.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class BandWideUtil {

    /* renamed from: a */
    private static long f30686a;

    /* renamed from: b */
    private static long f30687b;

    /* renamed from: c */
    private static long f30688c;

    /* compiled from: BandWideUtil.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class C11335a {

        /* renamed from: a */
        private static BandWideUtil f30689a = new BandWideUtil();
    }

    /* renamed from: a */
    public static BandWideUtil m22300a() {
        return C11335a.f30689a;
    }

    /* renamed from: b */
    public final synchronized void m22299b() {
        if (f30686a == 0) {
            f30686a = SystemClock.elapsedRealtime();
            f30688c = TrafficStats.getTotalRxBytes();
        }
    }

    /* renamed from: c */
    public final synchronized void m22298c() {
        if (f30686a != 0 && f30688c != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - f30686a;
            if (elapsedRealtime != 0) {
                try {
                    if (TrafficStats.getTotalRxBytes() != -1) {
                        long totalRxBytes = ((TrafficStats.getTotalRxBytes() - f30688c) * 1000) / elapsedRealtime;
                        if (totalRxBytes == 0) {
                            f30687b = 1L;
                        } else {
                            f30687b = totalRxBytes;
                        }
                    } else {
                        f30687b = 0L;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            m22297d();
        }
    }

    /* renamed from: d */
    public final synchronized void m22297d() {
        f30688c = 0L;
        f30686a = 0L;
    }

    /* renamed from: e */
    public final long m22296e() {
        return f30687b;
    }

    private BandWideUtil() {
    }
}
