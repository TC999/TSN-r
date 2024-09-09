package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class UploadInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f11130a = 1;

    /* renamed from: b  reason: collision with root package name */
    private String f11131b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f11132c;

    public int getCoordType() {
        return this.f11130a;
    }

    public LatLonPoint getPoint() {
        return this.f11132c;
    }

    public String getUserID() {
        return this.f11131b;
    }

    public void setCoordType(int i4) {
        if (i4 != 0 && i4 != 1) {
            this.f11130a = 1;
        } else {
            this.f11130a = i4;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f11132c = latLonPoint;
    }

    public void setUserID(String str) {
        this.f11131b = str;
    }
}
