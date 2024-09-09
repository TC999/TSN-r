package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class Chestnut<T> {

    /* renamed from: a  reason: collision with root package name */
    public T f51968a;

    /* renamed from: b  reason: collision with root package name */
    public long f51969b;

    /* renamed from: c  reason: collision with root package name */
    public long f51970c;

    public synchronized void a(T t3, long j4) {
        if (t3 == null) {
            return;
        }
        this.f51968a = t3;
        this.f51969b = System.currentTimeMillis();
        this.f51970c = j4;
    }

    public synchronized T a() {
        T t3 = this.f51968a;
        if (t3 == null) {
            return null;
        }
        int i4 = (this.f51970c > 0L ? 1 : (this.f51970c == 0L ? 0 : -1));
        if (i4 < 0) {
            return t3;
        }
        if (i4 != 0 && Math.abs(System.currentTimeMillis() - this.f51969b) <= this.f51970c) {
            return this.f51968a;
        }
        this.f51968a = null;
        return null;
    }
}
