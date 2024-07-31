package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NearbyInfo {

    /* renamed from: a */
    private String f7420a;

    /* renamed from: b */
    private LatLonPoint f7421b;

    /* renamed from: c */
    private long f7422c;

    /* renamed from: d */
    private int f7423d;

    /* renamed from: e */
    private int f7424e;

    public int getDistance() {
        return this.f7423d;
    }

    public int getDrivingDistance() {
        return this.f7424e;
    }

    public LatLonPoint getPoint() {
        return this.f7421b;
    }

    public long getTimeStamp() {
        return this.f7422c;
    }

    public String getUserID() {
        return this.f7420a;
    }

    public void setDistance(int i) {
        this.f7423d = i;
    }

    public void setDrivingDistance(int i) {
        this.f7424e = i;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f7421b = latLonPoint;
    }

    public void setTimeStamp(long j) {
        this.f7422c = j;
    }

    public void setUserID(String str) {
        this.f7420a = str;
    }
}
