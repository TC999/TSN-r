package com.tencent.gatherer.a.a.a.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f51574a;

    /* renamed from: b  reason: collision with root package name */
    private Object f51575b;

    protected abstract Object a();

    public Object b() {
        if (!this.f51574a) {
            this.f51575b = a();
            this.f51574a = true;
        }
        return this.f51575b;
    }
}
