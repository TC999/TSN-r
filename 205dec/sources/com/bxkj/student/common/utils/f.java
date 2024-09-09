package com.bxkj.student.common.utils;

import com.amap.api.maps.model.LatLng;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: KalmanLatLong.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private float f19617b;

    /* renamed from: c  reason: collision with root package name */
    private long f19618c;

    /* renamed from: d  reason: collision with root package name */
    private double f19619d;

    /* renamed from: e  reason: collision with root package name */
    private double f19620e;

    /* renamed from: a  reason: collision with root package name */
    private final float f19616a = 3.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f19621f = -1.0f;

    public f(float Q_metres_per_second) {
        this.f19617b = Q_metres_per_second;
    }

    public LatLng a(double lat_measurement, double lng_measurement, float accuracy, long TimeStamp_milliseconds) {
        float f4 = accuracy < 3.0f ? 3.0f : accuracy;
        float f5 = this.f19621f;
        if (f5 < 0.0f) {
            b(lat_measurement, lng_measurement, f4, TimeStamp_milliseconds);
        } else {
            long j4 = TimeStamp_milliseconds - this.f19618c;
            if (j4 > 0) {
                float f6 = this.f19617b;
                this.f19621f = f5 + (((((float) j4) * f6) * f6) / 1000.0f);
                this.f19618c = TimeStamp_milliseconds;
            }
            float f7 = this.f19621f;
            float f8 = f7 / ((f4 * f4) + f7);
            double d4 = this.f19619d;
            double d5 = f8;
            Double.isNaN(d5);
            this.f19619d = d4 + ((lat_measurement - d4) * d5);
            double d6 = this.f19620e;
            Double.isNaN(d5);
            this.f19620e = d6 + (d5 * (lng_measurement - d6));
            this.f19621f = (1.0f - f8) * f7;
        }
        return new LatLng(this.f19619d, this.f19620e);
    }

    public void b(double lat, double lng, float accuracy, long TimeStamp_milliseconds) {
        this.f19619d = lat;
        this.f19620e = lng;
        this.f19621f = accuracy * accuracy;
        this.f19618c = TimeStamp_milliseconds;
    }

    public long c() {
        return this.f19618c;
    }

    public float d() {
        return (float) Math.sqrt(this.f19621f);
    }

    public double e() {
        return this.f19619d;
    }

    public double f() {
        return this.f19620e;
    }
}
