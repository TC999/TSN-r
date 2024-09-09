package com.qq.e.comm.plugin.rewardvideo;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f45921a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    private final int f45922b;

    public d(String str) {
        this.f45922b = com.qq.e.comm.plugin.t.c.a("rewardVideoLoadRetryTimes", str, 2);
        b();
    }

    public boolean a() {
        return this.f45921a.decrementAndGet() >= 0;
    }

    public void b() {
        this.f45921a.set(this.f45922b - 1);
    }
}
