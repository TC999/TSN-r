package com.amap.api.services.busline;

import com.amap.api.col.s.j4;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusStationQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f10915a;

    /* renamed from: b  reason: collision with root package name */
    private String f10916b;

    /* renamed from: c  reason: collision with root package name */
    private int f10917c = 20;

    /* renamed from: d  reason: collision with root package name */
    private int f10918d = 1;

    public BusStationQuery(String str, String str2) {
        this.f10915a = str;
        this.f10916b = str2;
        if (a()) {
            return;
        }
        new IllegalArgumentException("Empty query").printStackTrace();
    }

    private boolean a() {
        return !j4.j(this.f10915a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusStationQuery busStationQuery = (BusStationQuery) obj;
            String str = this.f10916b;
            if (str == null) {
                if (busStationQuery.f10916b != null) {
                    return false;
                }
            } else if (!str.equals(busStationQuery.f10916b)) {
                return false;
            }
            if (this.f10918d == busStationQuery.f10918d && this.f10917c == busStationQuery.f10917c) {
                String str2 = this.f10915a;
                if (str2 == null) {
                    if (busStationQuery.f10915a != null) {
                        return false;
                    }
                } else if (!str2.equals(busStationQuery.f10915a)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public String getCity() {
        return this.f10916b;
    }

    public int getPageNumber() {
        return this.f10918d;
    }

    public int getPageSize() {
        return this.f10917c;
    }

    public String getQueryString() {
        return this.f10915a;
    }

    public int hashCode() {
        String str = this.f10916b;
        int hashCode = ((((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f10918d) * 31) + this.f10917c) * 31;
        String str2 = this.f10915a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f10916b = str;
    }

    public void setPageNumber(int i4) {
        if (i4 <= 0) {
            i4 = 1;
        }
        this.f10918d = i4;
    }

    public void setPageSize(int i4) {
        this.f10917c = i4;
    }

    public void setQueryString(String str) {
        this.f10915a = str;
    }

    public boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        String str = this.f10916b;
        if (str == null) {
            if (busStationQuery.f10916b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f10916b)) {
            return false;
        }
        if (this.f10917c != busStationQuery.f10917c) {
            return false;
        }
        String str2 = this.f10915a;
        if (str2 == null) {
            if (busStationQuery.f10915a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f10915a)) {
            return false;
        }
        return true;
    }

    /* renamed from: clone */
    public BusStationQuery m32clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f10915a, this.f10916b);
        busStationQuery.setPageNumber(this.f10918d);
        busStationQuery.setPageSize(this.f10917c);
        return busStationQuery;
    }
}
