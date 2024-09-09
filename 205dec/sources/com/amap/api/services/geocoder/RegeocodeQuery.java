package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RegeocodeQuery {

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f11082a;

    /* renamed from: b  reason: collision with root package name */
    private float f11083b;

    /* renamed from: c  reason: collision with root package name */
    private String f11084c = "autonavi";

    /* renamed from: d  reason: collision with root package name */
    private String f11085d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f11086e = "distance";

    /* renamed from: f  reason: collision with root package name */
    private String f11087f = "base";

    public RegeocodeQuery(LatLonPoint latLonPoint, float f4, String str) {
        this.f11082a = latLonPoint;
        this.f11083b = f4;
        setLatLonType(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
            String str = this.f11084c;
            if (str == null) {
                if (regeocodeQuery.f11084c != null) {
                    return false;
                }
            } else if (!str.equals(regeocodeQuery.f11084c)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f11082a;
            if (latLonPoint == null) {
                if (regeocodeQuery.f11082a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(regeocodeQuery.f11082a)) {
                return false;
            }
            if (Float.floatToIntBits(this.f11083b) == Float.floatToIntBits(regeocodeQuery.f11083b) && this.f11086e.equals(regeocodeQuery.f11086e)) {
                String str2 = this.f11087f;
                if (str2 == null) {
                    if (regeocodeQuery.f11087f != null) {
                        return false;
                    }
                } else if (!str2.equals(regeocodeQuery.f11087f)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public String getExtensions() {
        return this.f11087f;
    }

    public String getLatLonType() {
        return this.f11084c;
    }

    public String getMode() {
        return this.f11086e;
    }

    public String getPoiType() {
        return this.f11085d;
    }

    public LatLonPoint getPoint() {
        return this.f11082a;
    }

    public float getRadius() {
        return this.f11083b;
    }

    public int hashCode() {
        String str = this.f11084c;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f11082a;
        return ((hashCode + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f11083b);
    }

    public void setExtensions(String str) {
        this.f11087f = str;
    }

    public void setLatLonType(String str) {
        if (str != null) {
            if (str.equals("autonavi") || str.equals("gps")) {
                this.f11084c = str;
            }
        }
    }

    public void setMode(String str) {
        this.f11086e = str;
    }

    public void setPoiType(String str) {
        this.f11085d = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f11082a = latLonPoint;
    }

    public void setRadius(float f4) {
        this.f11083b = f4;
    }
}
