package com.amap.api.trace;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TraceLocation {

    /* renamed from: a  reason: collision with root package name */
    private double f11659a;

    /* renamed from: b  reason: collision with root package name */
    private double f11660b;

    /* renamed from: c  reason: collision with root package name */
    private float f11661c;

    /* renamed from: d  reason: collision with root package name */
    private float f11662d;

    /* renamed from: e  reason: collision with root package name */
    private long f11663e;

    public TraceLocation(double d4, double d5, float f4, float f5, long j4) {
        this.f11659a = a(d4);
        this.f11660b = a(d5);
        this.f11661c = (int) ((f4 * 3600.0f) / 1000.0f);
        this.f11662d = (int) f5;
        this.f11663e = j4;
    }

    private static double a(double d4) {
        double round = Math.round(d4 * 1000000.0d);
        Double.isNaN(round);
        return round / 1000000.0d;
    }

    public TraceLocation copy() {
        TraceLocation traceLocation = new TraceLocation();
        traceLocation.f11662d = this.f11662d;
        traceLocation.f11659a = this.f11659a;
        traceLocation.f11660b = this.f11660b;
        traceLocation.f11661c = this.f11661c;
        traceLocation.f11663e = this.f11663e;
        return traceLocation;
    }

    public float getBearing() {
        return this.f11662d;
    }

    public double getLatitude() {
        return this.f11659a;
    }

    public double getLongitude() {
        return this.f11660b;
    }

    public float getSpeed() {
        return this.f11661c;
    }

    public long getTime() {
        return this.f11663e;
    }

    public void setBearing(float f4) {
        this.f11662d = (int) f4;
    }

    public void setLatitude(double d4) {
        this.f11659a = a(d4);
    }

    public void setLongitude(double d4) {
        this.f11660b = a(d4);
    }

    public void setSpeed(float f4) {
        this.f11661c = (int) ((f4 * 3600.0f) / 1000.0f);
    }

    public void setTime(long j4) {
        this.f11663e = j4;
    }

    public String toString() {
        return this.f11659a + ",longtitude " + this.f11660b + ",speed " + this.f11661c + ",bearing " + this.f11662d + ",time " + this.f11663e;
    }

    public TraceLocation() {
    }
}
