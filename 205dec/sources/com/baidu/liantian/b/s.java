package com.baidu.liantian.b;

import android.annotation.SuppressLint;
import android.net.TrafficStats;

/* compiled from: TrafficStatsUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s {
    @SuppressLint({"NewApi"})
    public static void a() {
        try {
            TrafficStats.setThreadStatsTag(155648);
        } catch (Throwable unused) {
            e.a();
        }
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        try {
            TrafficStats.clearThreadStatsTag();
        } catch (Throwable unused) {
            e.a();
        }
    }
}
