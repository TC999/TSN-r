package com.bxkj.student.common.utils;

import com.amap.api.maps.model.LatLng;

/* renamed from: com.bxkj.student.common.utils.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class KalmanLatLong {

    /* renamed from: b */
    private float f16218b;

    /* renamed from: c */
    private long f16219c;

    /* renamed from: d */
    private double f16220d;

    /* renamed from: e */
    private double f16221e;

    /* renamed from: a */
    private final float f16217a = 3.0f;

    /* renamed from: f */
    private float f16222f = -1.0f;

    public KalmanLatLong(float Q_metres_per_second) {
        this.f16218b = Q_metres_per_second;
    }

    /* renamed from: a */
    public LatLng m42839a(double lat_measurement, double lng_measurement, float accuracy, long TimeStamp_milliseconds) {
        float f = accuracy < 3.0f ? 3.0f : accuracy;
        float f2 = this.f16222f;
        if (f2 < 0.0f) {
            m42838b(lat_measurement, lng_measurement, f, TimeStamp_milliseconds);
        } else {
            long j = TimeStamp_milliseconds - this.f16219c;
            if (j > 0) {
                float f3 = this.f16218b;
                this.f16222f = f2 + (((((float) j) * f3) * f3) / 1000.0f);
                this.f16219c = TimeStamp_milliseconds;
            }
            float f4 = this.f16222f;
            float f5 = f4 / ((f * f) + f4);
            double d = this.f16220d;
            double d2 = f5;
            Double.isNaN(d2);
            this.f16220d = d + ((lat_measurement - d) * d2);
            double d3 = this.f16221e;
            Double.isNaN(d2);
            this.f16221e = d3 + (d2 * (lng_measurement - d3));
            this.f16222f = (1.0f - f5) * f4;
        }
        return new LatLng(this.f16220d, this.f16221e);
    }

    /* renamed from: b */
    public void m42838b(double lat, double lng, float accuracy, long TimeStamp_milliseconds) {
        this.f16220d = lat;
        this.f16221e = lng;
        this.f16222f = accuracy * accuracy;
        this.f16219c = TimeStamp_milliseconds;
    }

    /* renamed from: c */
    public long m42837c() {
        return this.f16219c;
    }

    /* renamed from: d */
    public float m42836d() {
        return (float) Math.sqrt(this.f16222f);
    }

    /* renamed from: e */
    public double m42835e() {
        return this.f16220d;
    }

    /* renamed from: f */
    public double m42834f() {
        return this.f16221e;
    }
}
