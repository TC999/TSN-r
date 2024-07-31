package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RegeocodeQuery {

    /* renamed from: a */
    private LatLonPoint f7388a;

    /* renamed from: b */
    private float f7389b;

    /* renamed from: c */
    private String f7390c = GeocodeSearch.AMAP;

    /* renamed from: d */
    private String f7391d = "";

    /* renamed from: e */
    private String f7392e = "distance";

    /* renamed from: f */
    private String f7393f = "base";

    public RegeocodeQuery(LatLonPoint latLonPoint, float f, String str) {
        this.f7388a = latLonPoint;
        this.f7389b = f;
        setLatLonType(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
            String str = this.f7390c;
            if (str == null) {
                if (regeocodeQuery.f7390c != null) {
                    return false;
                }
            } else if (!str.equals(regeocodeQuery.f7390c)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f7388a;
            if (latLonPoint == null) {
                if (regeocodeQuery.f7388a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(regeocodeQuery.f7388a)) {
                return false;
            }
            if (Float.floatToIntBits(this.f7389b) == Float.floatToIntBits(regeocodeQuery.f7389b) && this.f7392e.equals(regeocodeQuery.f7392e)) {
                String str2 = this.f7393f;
                if (str2 == null) {
                    if (regeocodeQuery.f7393f != null) {
                        return false;
                    }
                } else if (!str2.equals(regeocodeQuery.f7393f)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public String getExtensions() {
        return this.f7393f;
    }

    public String getLatLonType() {
        return this.f7390c;
    }

    public String getMode() {
        return this.f7392e;
    }

    public String getPoiType() {
        return this.f7391d;
    }

    public LatLonPoint getPoint() {
        return this.f7388a;
    }

    public float getRadius() {
        return this.f7389b;
    }

    public int hashCode() {
        String str = this.f7390c;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f7388a;
        return ((hashCode + (latLonPoint != null ? latLonPoint.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f7389b);
    }

    public void setExtensions(String str) {
        this.f7393f = str;
    }

    public void setLatLonType(String str) {
        if (str != null) {
            if (str.equals(GeocodeSearch.AMAP) || str.equals(GeocodeSearch.GPS)) {
                this.f7390c = str;
            }
        }
    }

    public void setMode(String str) {
        this.f7392e = str;
    }

    public void setPoiType(String str) {
        this.f7391d = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f7388a = latLonPoint;
    }

    public void setRadius(float f) {
        this.f7389b = f;
    }
}
