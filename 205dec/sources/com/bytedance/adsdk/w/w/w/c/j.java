package com.bytedance.adsdk.w.w.w.c;

import com.bytedance.adsdk.w.w.sr.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class j implements r0.a {

    /* renamed from: a  reason: collision with root package name */
    protected r0.a f26454a;

    /* renamed from: b  reason: collision with root package name */
    protected r0.a f26455b;

    /* renamed from: c  reason: collision with root package name */
    protected xv f26456c;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(xv xvVar) {
        this.f26456c = xvVar;
    }

    public void a(r0.a aVar) {
        this.f26454a = aVar;
    }

    public void b(r0.a aVar) {
        this.f26455b = aVar;
    }

    public p0.a c() {
        return com.bytedance.adsdk.w.w.sr.f.OPERATOR_RESULT;
    }

    public String toString() {
        return w();
    }

    public String w() {
        return this.f26454a.w() + this.f26456c.c() + this.f26455b.w();
    }
}
