package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NearbyInfo {

    /* renamed from: a  reason: collision with root package name */
    private String f11114a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11115b;

    /* renamed from: c  reason: collision with root package name */
    private long f11116c;

    /* renamed from: d  reason: collision with root package name */
    private int f11117d;

    /* renamed from: e  reason: collision with root package name */
    private int f11118e;

    public int getDistance() {
        return this.f11117d;
    }

    public int getDrivingDistance() {
        return this.f11118e;
    }

    public LatLonPoint getPoint() {
        return this.f11115b;
    }

    public long getTimeStamp() {
        return this.f11116c;
    }

    public String getUserID() {
        return this.f11114a;
    }

    public void setDistance(int i4) {
        this.f11117d = i4;
    }

    public void setDrivingDistance(int i4) {
        this.f11118e = i4;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f11115b = latLonPoint;
    }

    public void setTimeStamp(long j4) {
        this.f11116c = j4;
    }

    public void setUserID(String str) {
        this.f11114a = str;
    }
}
