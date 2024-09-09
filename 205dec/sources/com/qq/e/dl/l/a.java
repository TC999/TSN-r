package com.qq.e.dl.l;

import android.view.View;
import com.qq.e.dl.l.e;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a<T extends View & e> extends h<com.qq.e.dl.l.k.b<T>> {

    /* renamed from: w  reason: collision with root package name */
    protected T f47039w;

    public a(com.qq.e.dl.a aVar) {
        super(aVar);
        T a4 = a(aVar);
        this.f47039w = a4;
        a4.a(this);
        this.f47070h = v();
    }

    protected abstract T a(com.qq.e.dl.a aVar);

    @Override // com.qq.e.dl.l.h
    public View m() {
        return this.f47039w;
    }

    protected com.qq.e.dl.l.k.b<T> v() {
        return new com.qq.e.dl.l.k.b<>(this, this.f47039w);
    }
}
