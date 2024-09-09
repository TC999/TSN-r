package com.bytedance.adsdk.lottie.c.w;

import android.graphics.Color;
import android.graphics.Paint;
import com.bytedance.adsdk.lottie.c.w.c;
import com.bytedance.adsdk.lottie.s;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p implements c.b {

    /* renamed from: a  reason: collision with root package name */
    private final c.b f25516a;

    /* renamed from: b  reason: collision with root package name */
    private final c<Integer, Integer> f25517b;

    /* renamed from: c  reason: collision with root package name */
    private final c<Float, Float> f25518c;

    /* renamed from: d  reason: collision with root package name */
    private final c<Float, Float> f25519d;

    /* renamed from: e  reason: collision with root package name */
    private final c<Float, Float> f25520e;

    /* renamed from: f  reason: collision with root package name */
    private final c<Float, Float> f25521f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25522g = true;

    public p(c.b bVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, s.w wVar) {
        this.f25516a = bVar;
        c<Integer, Integer> c4 = wVar.a().c();
        this.f25517b = c4;
        c4.f(this);
        aVar.l(c4);
        c<Float, Float> c5 = wVar.d().c();
        this.f25518c = c5;
        c5.f(this);
        aVar.l(c5);
        c<Float, Float> c6 = wVar.e().c();
        this.f25519d = c6;
        c6.f(this);
        aVar.l(c6);
        c<Float, Float> c7 = wVar.b().c();
        this.f25520e = c7;
        c7.f(this);
        aVar.l(c7);
        c<Float, Float> c8 = wVar.c().c();
        this.f25521f = c8;
        c8.f(this);
        aVar.l(c8);
    }

    public void a(Paint paint) {
        if (this.f25522g) {
            this.f25522g = false;
            double floatValue = this.f25519d.j().floatValue();
            Double.isNaN(floatValue);
            double d4 = floatValue * 0.017453292519943295d;
            float floatValue2 = this.f25520e.j().floatValue();
            float sin = ((float) Math.sin(d4)) * floatValue2;
            float cos = ((float) Math.cos(d4 + 3.141592653589793d)) * floatValue2;
            int intValue = this.f25517b.j().intValue();
            paint.setShadowLayer(this.f25521f.j().floatValue(), sin, cos, Color.argb(Math.round(this.f25518c.j().floatValue()), Color.red(intValue), Color.green(intValue), Color.blue(intValue)));
        }
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        this.f25522g = true;
        this.f25516a.c();
    }
}
