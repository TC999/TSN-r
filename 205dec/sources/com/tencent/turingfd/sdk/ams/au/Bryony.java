package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class Bryony<T> {

    /* renamed from: a  reason: collision with root package name */
    public volatile T f51933a;

    public abstract T a();

    public final T b() {
        T t3 = this.f51933a;
        if (t3 == null) {
            synchronized (this) {
                t3 = this.f51933a;
                if (t3 == null) {
                    t3 = a();
                    this.f51933a = t3;
                }
            }
        }
        return t3;
    }
}
