package com.amap.api.col.p0003l;

import com.autonavi.amap.mapcore.DPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Bounds.java */
/* renamed from: com.amap.api.col.3l.k2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k2 {

    /* renamed from: a  reason: collision with root package name */
    public final double f8229a;

    /* renamed from: b  reason: collision with root package name */
    public final double f8230b;

    /* renamed from: c  reason: collision with root package name */
    public final double f8231c;

    /* renamed from: d  reason: collision with root package name */
    public final double f8232d;

    /* renamed from: e  reason: collision with root package name */
    public final double f8233e;

    /* renamed from: f  reason: collision with root package name */
    public final double f8234f;

    public k2(double d4, double d5, double d6, double d7) {
        this.f8229a = d4;
        this.f8230b = d6;
        this.f8231c = d5;
        this.f8232d = d7;
        this.f8233e = (d4 + d5) / 2.0d;
        this.f8234f = (d6 + d7) / 2.0d;
    }

    private boolean b(double d4, double d5, double d6, double d7) {
        return d4 < this.f8231c && this.f8229a < d5 && d6 < this.f8232d && this.f8230b < d7;
    }

    public final boolean a(double d4, double d5) {
        return this.f8229a <= d4 && d4 <= this.f8231c && this.f8230b <= d5 && d5 <= this.f8232d;
    }

    public final boolean c(k2 k2Var) {
        return b(k2Var.f8229a, k2Var.f8231c, k2Var.f8230b, k2Var.f8232d);
    }

    public final boolean d(DPoint dPoint) {
        return a(dPoint.f11671x, dPoint.f11672y);
    }

    public final boolean e(k2 k2Var) {
        return k2Var.f8229a >= this.f8229a && k2Var.f8231c <= this.f8231c && k2Var.f8230b >= this.f8230b && k2Var.f8232d <= this.f8232d;
    }
}
