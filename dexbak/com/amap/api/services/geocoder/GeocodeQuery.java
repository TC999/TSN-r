package com.amap.api.services.geocoder;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GeocodeQuery {

    /* renamed from: a */
    private String f7364a;

    /* renamed from: b */
    private String f7365b;

    /* renamed from: c */
    private String f7366c;

    public GeocodeQuery(String str, String str2) {
        this.f7364a = str;
        this.f7365b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
            String str = this.f7365b;
            if (str == null) {
                if (geocodeQuery.f7365b != null) {
                    return false;
                }
            } else if (!str.equals(geocodeQuery.f7365b)) {
                return false;
            }
            String str2 = this.f7364a;
            if (str2 == null) {
                if (geocodeQuery.f7364a != null) {
                    return false;
                }
            } else if (!str2.equals(geocodeQuery.f7364a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getCity() {
        return this.f7365b;
    }

    public String getCountry() {
        return this.f7366c;
    }

    public String getLocationName() {
        return this.f7364a;
    }

    public int hashCode() {
        String str = this.f7365b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f7364a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f7365b = str;
    }

    public void setCountry(String str) {
        this.f7366c = str;
    }

    public void setLocationName(String str) {
        this.f7364a = str;
    }
}
