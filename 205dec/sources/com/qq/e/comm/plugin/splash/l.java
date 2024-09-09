package com.qq.e.comm.plugin.splash;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class l {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f46141a = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f46141a.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f46141a.compareAndSet(6, 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f46141a.compareAndSet(7, 0) || this.f46141a.compareAndSet(6, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f46141a.compareAndSet(2, 0) || this.f46141a.compareAndSet(3, 0) || this.f46141a.compareAndSet(5, 0) || this.f46141a.compareAndSet(6, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f46141a.compareAndSet(0, 1) || this.f46141a.compareAndSet(4, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.f46141a.compareAndSet(2, 4) || this.f46141a.compareAndSet(3, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f46141a.compareAndSet(1, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f46141a.compareAndSet(5, 6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.f46141a.compareAndSet(4, 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return this.f46141a.compareAndSet(2, 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.f46141a.get() == 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f46141a.get() == 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.f46141a.get() == 2 || this.f46141a.get() == 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f46141a.get() == 5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f46141a.get() == 7 || this.f46141a.get() == 6;
    }
}
