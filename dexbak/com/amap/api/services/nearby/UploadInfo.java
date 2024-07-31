package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UploadInfo {

    /* renamed from: a */
    private int f7436a = 1;

    /* renamed from: b */
    private String f7437b;

    /* renamed from: c */
    private LatLonPoint f7438c;

    public int getCoordType() {
        return this.f7436a;
    }

    public LatLonPoint getPoint() {
        return this.f7438c;
    }

    public String getUserID() {
        return this.f7437b;
    }

    public void setCoordType(int i) {
        if (i != 0 && i != 1) {
            this.f7436a = 1;
        } else {
            this.f7436a = i;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f7438c = latLonPoint;
    }

    public void setUserID(String str) {
        this.f7437b = str;
    }
}
