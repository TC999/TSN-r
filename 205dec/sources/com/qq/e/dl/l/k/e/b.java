package com.qq.e.dl.l.k.e;

import android.view.View;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends d {

    /* renamed from: x  reason: collision with root package name */
    protected final c f47190x;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public h a(com.qq.e.dl.a aVar) {
            return new b(aVar);
        }
    }

    public b(com.qq.e.dl.a aVar) {
        super(aVar);
        c a4 = a(aVar);
        this.f47190x = a4;
        a4.a(this);
        this.f47070h = new com.qq.e.dl.l.k.e.a(this, this.f47190x);
    }

    protected c a(com.qq.e.dl.a aVar) {
        return new c(aVar.b());
    }

    @Override // com.qq.e.dl.l.h
    public View m() {
        return this.f47190x;
    }
}
