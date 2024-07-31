package com.amap.api.col.p0463l;

import com.github.mikephil.charting.utils.Utils;

/* renamed from: com.amap.api.col.3l.h9 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AmapLocation {

    /* renamed from: a */
    public String f4475a;

    /* renamed from: b */
    public long f4476b = 0;

    /* renamed from: c */
    public long f4477c = 0;

    /* renamed from: d */
    public double f4478d = Utils.DOUBLE_EPSILON;

    /* renamed from: e */
    public double f4479e = Utils.DOUBLE_EPSILON;

    /* renamed from: f */
    public double f4480f = Utils.DOUBLE_EPSILON;

    /* renamed from: g */
    public float f4481g = 0.0f;

    /* renamed from: h */
    public float f4482h = 0.0f;

    /* renamed from: i */
    public float f4483i = 0.0f;

    /* renamed from: j */
    public boolean f4484j = false;

    public AmapLocation(String str) {
        this.f4475a = str;
    }

    /* renamed from: a */
    public final double m54741a(AmapLocation amapLocation) {
        return amapLocation != null ? GeoUtil.m53831a(this.f4479e, this.f4478d, amapLocation.f4479e, amapLocation.f4478d) : Utils.DOUBLE_EPSILON;
    }
}
