package com.bykv.vk.component.ttvideo.utils;

import android.os.SystemClock;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f24916a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f24917b = 2;

    /* renamed from: c  reason: collision with root package name */
    private int f24918c = 2;

    /* renamed from: d  reason: collision with root package name */
    private int f24919d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f24920e = 0;

    public void a() {
        this.f24919d = 0;
        if (this.f24918c == this.f24916a) {
            this.f24920e = SystemClock.elapsedRealtime();
        }
    }

    public int b() {
        if (this.f24918c == this.f24916a) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i4 = (int) (elapsedRealtime - this.f24920e);
            if (i4 >= 0) {
                this.f24919d += i4;
            }
            this.f24920e = elapsedRealtime;
        }
        return this.f24919d;
    }

    public void c() {
        this.f24918c = this.f24917b;
        this.f24919d = 0;
        this.f24920e = 0L;
    }

    public void d() {
        if (this.f24918c == this.f24917b) {
            this.f24918c = this.f24916a;
            this.f24920e = SystemClock.elapsedRealtime();
        }
    }

    public void e() {
        if (this.f24918c == this.f24916a) {
            this.f24918c = this.f24917b;
            int elapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.f24920e);
            if (elapsedRealtime >= 0) {
                this.f24919d += elapsedRealtime;
            }
        }
    }
}
