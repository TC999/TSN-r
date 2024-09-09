package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class InputtipsQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f11101a;

    /* renamed from: b  reason: collision with root package name */
    private String f11102b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11103c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f11104d = null;

    /* renamed from: e  reason: collision with root package name */
    private LatLonPoint f11105e;

    public InputtipsQuery(String str, String str2) {
        this.f11101a = str;
        this.f11102b = str2;
    }

    public String getCity() {
        return this.f11102b;
    }

    public boolean getCityLimit() {
        return this.f11103c;
    }

    public String getKeyword() {
        return this.f11101a;
    }

    public LatLonPoint getLocation() {
        return this.f11105e;
    }

    public String getType() {
        return this.f11104d;
    }

    public void setCityLimit(boolean z3) {
        this.f11103c = z3;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f11105e = latLonPoint;
    }

    public void setType(String str) {
        this.f11104d = str;
    }
}
