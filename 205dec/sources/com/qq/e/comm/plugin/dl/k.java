package com.qq.e.comm.plugin.dl;

import com.qq.e.comm.plugin.util.d1;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k extends b implements com.qq.e.comm.plugin.k0.e.a {

    /* renamed from: q  reason: collision with root package name */
    private int f42475q;

    /* renamed from: r  reason: collision with root package name */
    private int f42476r;

    private boolean a(int i4, int i5, int[] iArr) {
        int h4 = com.qq.e.comm.plugin.k0.c.h(this.f42364c);
        if (com.qq.e.comm.plugin.k0.c.a(h4)) {
            return h4 == 1;
        }
        return (i4 > 0 && i5 > i4) || (iArr != null && iArr.length > 0);
    }

    @Override // com.qq.e.comm.plugin.k0.e.a
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.dl.b
    public void g() {
        super.g();
        this.f42475q = com.qq.e.comm.plugin.k0.c.c(this.f42364c, this.f42369h);
        boolean f4 = com.qq.e.comm.plugin.k0.c.f(this.f42364c, this.f42369h);
        int i4 = com.qq.e.comm.plugin.k0.c.i(this.f42364c, this.f42369h);
        int h4 = com.qq.e.comm.plugin.k0.c.h(this.f42364c, this.f42369h);
        int[] g4 = com.qq.e.comm.plugin.k0.c.g(this.f42364c, this.f42369h);
        boolean a4 = a(i4, h4, g4);
        if (a4) {
            this.f42476r = com.qq.e.comm.plugin.k0.c.b(this.f42364c, this.f42369h);
        } else {
            this.f42476r = com.qq.e.comm.plugin.k0.c.a(this.f42364c, this.f42369h);
        }
        com.qq.e.comm.plugin.k0.e.b bVar = new com.qq.e.comm.plugin.k0.e.b(this.f42475q, this.f42476r);
        bVar.a(this);
        if (a4) {
            bVar.a(f4);
            bVar.c(i4);
            bVar.b(h4);
            bVar.a(g4);
            bVar.b(true);
        }
        this.f42365d = bVar;
        this.f42376o = com.qq.e.comm.plugin.k0.c.b();
    }

    @Override // com.qq.e.comm.plugin.k0.e.a
    public void a(float f4) {
        if (f4 < this.f42376o) {
            this.f42377p = false;
        } else if (this.f42377p) {
        } else {
            this.f42377p = true;
            this.f42375n = System.currentTimeMillis();
            d1.a("gdt_tag_sensor", "onShakeProgress mMotionStartTime = " + this.f42375n);
        }
    }

    @Override // com.qq.e.comm.plugin.k0.e.a
    public void a(float[] fArr) {
        com.qq.e.dl.l.d dVar = this.f42370i.get();
        if (dVar != null && h()) {
            try {
                com.qq.e.dl.l.j.c f4 = f();
                long currentTimeMillis = System.currentTimeMillis();
                d1.a("gdt_tag_sensor", "onShakeComplete motionEndTime = " + currentTimeMillis);
                f4.a("motionDuration", Long.valueOf(currentTimeMillis - this.f42375n));
                f4.f47122c.put("shakeMaxAcceleration", fArr);
                dVar.b(this.f42368g, f4);
            } catch (JSONException e4) {
                d1.a("gdt_tag_sensor", "shake complete but err", e4);
            }
        }
    }
}
