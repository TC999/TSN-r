package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class InputtipsQuery implements Cloneable {

    /* renamed from: a */
    private String f7407a;

    /* renamed from: b */
    private String f7408b;

    /* renamed from: c */
    private boolean f7409c = false;

    /* renamed from: d */
    private String f7410d = null;

    /* renamed from: e */
    private LatLonPoint f7411e;

    public InputtipsQuery(String str, String str2) {
        this.f7407a = str;
        this.f7408b = str2;
    }

    public String getCity() {
        return this.f7408b;
    }

    public boolean getCityLimit() {
        return this.f7409c;
    }

    public String getKeyword() {
        return this.f7407a;
    }

    public LatLonPoint getLocation() {
        return this.f7411e;
    }

    public String getType() {
        return this.f7410d;
    }

    public void setCityLimit(boolean z) {
        this.f7409c = z;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f7411e = latLonPoint;
    }

    public void setType(String str) {
        this.f7410d = str;
    }
}
