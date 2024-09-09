package com.amap.api.services.geocoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GeocodeQuery {

    /* renamed from: a  reason: collision with root package name */
    private String f11058a;

    /* renamed from: b  reason: collision with root package name */
    private String f11059b;

    /* renamed from: c  reason: collision with root package name */
    private String f11060c;

    public GeocodeQuery(String str, String str2) {
        this.f11058a = str;
        this.f11059b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
            String str = this.f11059b;
            if (str == null) {
                if (geocodeQuery.f11059b != null) {
                    return false;
                }
            } else if (!str.equals(geocodeQuery.f11059b)) {
                return false;
            }
            String str2 = this.f11058a;
            if (str2 == null) {
                if (geocodeQuery.f11058a != null) {
                    return false;
                }
            } else if (!str2.equals(geocodeQuery.f11058a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getCity() {
        return this.f11059b;
    }

    public String getCountry() {
        return this.f11060c;
    }

    public String getLocationName() {
        return this.f11058a;
    }

    public int hashCode() {
        String str = this.f11059b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f11058a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f11059b = str;
    }

    public void setCountry(String str) {
        this.f11060c = str;
    }

    public void setLocationName(String str) {
        this.f11058a = str;
    }
}
