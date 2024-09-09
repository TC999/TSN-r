package com.qq.e.comm.plugin.util;

import android.os.SystemClock;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class b2 {

    /* renamed from: a  reason: collision with root package name */
    private final int f46380a;

    /* renamed from: b  reason: collision with root package name */
    private int f46381b;

    /* renamed from: c  reason: collision with root package name */
    private long f46382c = -1;

    public b2(int i4) {
        this.f46380a = i4;
        this.f46381b = i4;
    }

    public int a() {
        return this.f46380a;
    }

    public boolean b() {
        if (this.f46382c == -1) {
            this.f46382c = SystemClock.elapsedRealtime();
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f46382c = elapsedRealtime;
        double d4 = elapsedRealtime - this.f46382c;
        double d5 = this.f46380a;
        Double.isNaN(d5);
        Double.isNaN(d4);
        double d6 = d4 * (d5 / 60000.0d);
        d1.a("throttling old:" + this.f46381b + " increase:" + d6, new Object[0]);
        double d7 = (double) this.f46381b;
        Double.isNaN(d7);
        int i4 = (int) (d7 + d6);
        this.f46381b = i4;
        int i5 = this.f46380a;
        if (i4 > i5) {
            this.f46381b = i5;
        }
        int i6 = this.f46381b;
        if (i6 < 1) {
            return true;
        }
        this.f46381b = i6 - 1;
        return false;
    }
}
