package com.bytedance.adsdk.lottie.c.c;

import com.bytedance.adsdk.lottie.c.w.c;
import com.bytedance.adsdk.lottie.xv.w.fz;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i implements t, c.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f25391a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f25392b;

    /* renamed from: c  reason: collision with root package name */
    private final List<c.b> f25393c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final fz.c f25394d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25395e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25396f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25397g;

    public i(com.bytedance.adsdk.lottie.xv.xv.a aVar, fz fzVar) {
        this.f25391a = fzVar.b();
        this.f25392b = fzVar.d();
        this.f25394d = fzVar.getType();
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c4 = fzVar.f().c();
        this.f25395e = c4;
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c5 = fzVar.e().c();
        this.f25396f = c5;
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c6 = fzVar.c().c();
        this.f25397g = c6;
        aVar.l(c4);
        aVar.l(c5);
        aVar.l(c6);
        c4.f(this);
        c5.f(this);
        c6.f(this);
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        for (int i4 = 0; i4 < this.f25393c.size(); i4++) {
            this.f25393c.get(i4).c();
        }
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(c.b bVar) {
        this.f25393c.add(bVar);
    }

    public com.bytedance.adsdk.lottie.c.w.c<?, Float> f() {
        return this.f25397g;
    }

    public boolean g() {
        return this.f25392b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz.c getType() {
        return this.f25394d;
    }

    public com.bytedance.adsdk.lottie.c.w.c<?, Float> h() {
        return this.f25395e;
    }

    public com.bytedance.adsdk.lottie.c.w.c<?, Float> i() {
        return this.f25396f;
    }
}
