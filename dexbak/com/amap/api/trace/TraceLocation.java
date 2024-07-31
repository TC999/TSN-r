package com.amap.api.trace;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TraceLocation {

    /* renamed from: a */
    private double f7965a;

    /* renamed from: b */
    private double f7966b;

    /* renamed from: c */
    private float f7967c;

    /* renamed from: d */
    private float f7968d;

    /* renamed from: e */
    private long f7969e;

    public TraceLocation(double d, double d2, float f, float f2, long j) {
        this.f7965a = m51739a(d);
        this.f7966b = m51739a(d2);
        this.f7967c = (int) ((f * 3600.0f) / 1000.0f);
        this.f7968d = (int) f2;
        this.f7969e = j;
    }

    /* renamed from: a */
    private static double m51739a(double d) {
        double round = Math.round(d * 1000000.0d);
        Double.isNaN(round);
        return round / 1000000.0d;
    }

    public TraceLocation copy() {
        TraceLocation traceLocation = new TraceLocation();
        traceLocation.f7968d = this.f7968d;
        traceLocation.f7965a = this.f7965a;
        traceLocation.f7966b = this.f7966b;
        traceLocation.f7967c = this.f7967c;
        traceLocation.f7969e = this.f7969e;
        return traceLocation;
    }

    public float getBearing() {
        return this.f7968d;
    }

    public double getLatitude() {
        return this.f7965a;
    }

    public double getLongitude() {
        return this.f7966b;
    }

    public float getSpeed() {
        return this.f7967c;
    }

    public long getTime() {
        return this.f7969e;
    }

    public void setBearing(float f) {
        this.f7968d = (int) f;
    }

    public void setLatitude(double d) {
        this.f7965a = m51739a(d);
    }

    public void setLongitude(double d) {
        this.f7966b = m51739a(d);
    }

    public void setSpeed(float f) {
        this.f7967c = (int) ((f * 3600.0f) / 1000.0f);
    }

    public void setTime(long j) {
        this.f7969e = j;
    }

    public String toString() {
        return this.f7965a + ",longtitude " + this.f7966b + ",speed " + this.f7967c + ",bearing " + this.f7968d + ",time " + this.f7969e;
    }

    public TraceLocation() {
    }
}
