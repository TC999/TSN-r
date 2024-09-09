package com.mbridge.msdk.foundation.same.net;

import android.net.TrafficStats;
import android.os.SystemClock;

/* compiled from: BandWideUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static long f39480a;

    /* renamed from: b  reason: collision with root package name */
    private static long f39481b;

    /* renamed from: c  reason: collision with root package name */
    private static long f39482c;

    /* compiled from: BandWideUtil.java */
    /* renamed from: com.mbridge.msdk.foundation.same.net.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static class C0741a {

        /* renamed from: a  reason: collision with root package name */
        private static a f39483a = new a();
    }

    public static a a() {
        return C0741a.f39483a;
    }

    public final synchronized void b() {
        if (f39480a == 0) {
            f39480a = SystemClock.elapsedRealtime();
            f39482c = TrafficStats.getTotalRxBytes();
        }
    }

    public final synchronized void c() {
        if (f39480a != 0 && f39482c != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - f39480a;
            if (elapsedRealtime != 0) {
                try {
                    if (TrafficStats.getTotalRxBytes() != -1) {
                        long totalRxBytes = ((TrafficStats.getTotalRxBytes() - f39482c) * 1000) / elapsedRealtime;
                        if (totalRxBytes == 0) {
                            f39481b = 1L;
                        } else {
                            f39481b = totalRxBytes;
                        }
                    } else {
                        f39481b = 0L;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            d();
        }
    }

    public final synchronized void d() {
        f39482c = 0L;
        f39480a = 0L;
    }

    public final long e() {
        return f39481b;
    }

    private a() {
    }
}
