package com.amap.api.col.p0463l;

import com.autonavi.amap.mapcore.DPoint;

/* renamed from: com.amap.api.col.3l.k2 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Bounds {

    /* renamed from: a */
    public final double f4592a;

    /* renamed from: b */
    public final double f4593b;

    /* renamed from: c */
    public final double f4594c;

    /* renamed from: d */
    public final double f4595d;

    /* renamed from: e */
    public final double f4596e;

    /* renamed from: f */
    public final double f4597f;

    public Bounds(double d, double d2, double d3, double d4) {
        this.f4592a = d;
        this.f4593b = d3;
        this.f4594c = d2;
        this.f4595d = d4;
        this.f4596e = (d + d2) / 2.0d;
        this.f4597f = (d3 + d4) / 2.0d;
    }

    /* renamed from: b */
    private boolean m54641b(double d, double d2, double d3, double d4) {
        return d < this.f4594c && this.f4592a < d2 && d3 < this.f4595d && this.f4593b < d4;
    }

    /* renamed from: a */
    public final boolean m54642a(double d, double d2) {
        return this.f4592a <= d && d <= this.f4594c && this.f4593b <= d2 && d2 <= this.f4595d;
    }

    /* renamed from: c */
    public final boolean m54640c(Bounds bounds) {
        return m54641b(bounds.f4592a, bounds.f4594c, bounds.f4593b, bounds.f4595d);
    }

    /* renamed from: d */
    public final boolean m54639d(DPoint dPoint) {
        return m54642a(dPoint.f7977x, dPoint.f7978y);
    }

    /* renamed from: e */
    public final boolean m54638e(Bounds bounds) {
        return bounds.f4592a >= this.f4592a && bounds.f4594c <= this.f4594c && bounds.f4593b >= this.f4593b && bounds.f4595d <= this.f4595d;
    }
}
