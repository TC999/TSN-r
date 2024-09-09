package com.qq.e.dl.l.k.f;

import android.view.View;
import com.qq.e.dl.l.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends d {

    /* renamed from: x  reason: collision with root package name */
    protected final b f47195x;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public h a(com.qq.e.dl.a aVar) {
            return new c(aVar);
        }
    }

    public c(com.qq.e.dl.a aVar) {
        super(aVar);
        b a4 = a(aVar);
        this.f47195x = a4;
        a4.a(this);
        this.f47070h = new com.qq.e.dl.l.k.f.a(this, this.f47195x);
    }

    protected b a(com.qq.e.dl.a aVar) {
        return new b(aVar.b());
    }

    @Override // com.qq.e.dl.l.h
    public View m() {
        return this.f47195x;
    }
}
