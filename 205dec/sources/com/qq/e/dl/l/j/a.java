package com.qq.e.dl.l.j;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
abstract class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private final c f47106a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f47107b;

    /* renamed from: c  reason: collision with root package name */
    private final int f47108c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f47109d;

    /* renamed from: e  reason: collision with root package name */
    private final d f47110e;

    /* renamed from: f  reason: collision with root package name */
    private final com.qq.e.dl.l.i.e f47111f;

    public a(c cVar) {
        this.f47106a = cVar;
        JSONObject jSONObject = cVar.f47122c;
        if (jSONObject != null && jSONObject.length() > 0) {
            this.f47107b = jSONObject.optInt("dm") == 1;
            this.f47108c = jSONObject.optInt("imnd", 0);
            this.f47109d = true ^ d();
            d a4 = d.a(jSONObject);
            this.f47110e = a4;
            this.f47111f = a4 == null ? com.qq.e.dl.l.i.e.a(jSONObject) : null;
            return;
        }
        this.f47107b = false;
        this.f47110e = null;
        this.f47111f = null;
        this.f47108c = 0;
        this.f47109d = !d();
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) {
        d dVar = this.f47110e;
        if (dVar != null) {
            dVar.b(view, pointF);
        }
        com.qq.e.dl.l.i.e eVar = this.f47111f;
        if (eVar != null) {
            eVar.c(view, motionEvent);
            return null;
        }
        return null;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        boolean z3 = false;
        if (this.f47107b && this.f47109d && d(view, motionEvent, pointF, pointF2)) {
            z3 = true;
        }
        d dVar = this.f47110e;
        if (dVar != null) {
            if (z3) {
                dVar.a(true, view);
            } else {
                dVar.a(view, pointF2);
            }
        }
        com.qq.e.dl.l.i.e eVar = this.f47111f;
        if (eVar != null) {
            if (z3) {
                eVar.a(view, motionEvent);
            } else {
                eVar.b(view, motionEvent);
            }
        }
        if (z3) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean c(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        com.qq.e.dl.l.i.e eVar;
        d dVar;
        boolean z3 = false;
        if (!this.f47109d) {
            this.f47109d = true;
            if (this.f47107b && d(view, motionEvent, pointF, pointF2)) {
                z3 = true;
            }
        }
        if (z3 && (dVar = this.f47110e) != null) {
            dVar.a(true, view);
        }
        if (z3 && (eVar = this.f47111f) != null) {
            eVar.a(view, motionEvent);
        }
        if (z3) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.dl.l.j.g
    public boolean d() {
        return this.f47108c > 0;
    }

    abstract boolean d(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2);

    @Override // com.qq.e.dl.l.j.g
    public c e() {
        return this.f47106a;
    }

    @Override // com.qq.e.dl.l.j.g
    public int f() {
        int i4 = this.f47108c;
        if (i4 > 0) {
            return i4;
        }
        return 0;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        boolean z3 = this.f47109d && d(view, motionEvent, pointF, pointF2);
        d dVar = this.f47110e;
        if (dVar != null) {
            dVar.a(z3, view);
        }
        com.qq.e.dl.l.i.e eVar = this.f47111f;
        if (eVar != null) {
            eVar.a(view, motionEvent);
        }
        if (z3) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.dl.l.j.g
    public com.qq.e.dl.l.i.d c() {
        return this.f47111f;
    }

    @Override // com.qq.e.dl.l.j.g
    public boolean a() {
        return (!this.f47107b && this.f47110e == null && this.f47111f == null) ? false : true;
    }

    @Override // com.qq.e.dl.l.j.g
    public void b() {
        this.f47109d = !d();
    }
}
