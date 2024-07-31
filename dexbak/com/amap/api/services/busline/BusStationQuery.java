package com.amap.api.services.busline;

import com.amap.api.col.p047s.C2082j4;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusStationQuery implements Cloneable {

    /* renamed from: a */
    private String f7219a;

    /* renamed from: b */
    private String f7220b;

    /* renamed from: c */
    private int f7221c = 20;

    /* renamed from: d */
    private int f7222d = 1;

    public BusStationQuery(String str, String str2) {
        this.f7219a = str;
        this.f7220b = str2;
        if (m51909a()) {
            return;
        }
        new IllegalArgumentException("Empty query").printStackTrace();
    }

    /* renamed from: a */
    private boolean m51909a() {
        return !C2082j4.m52824j(this.f7219a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusStationQuery busStationQuery = (BusStationQuery) obj;
            String str = this.f7220b;
            if (str == null) {
                if (busStationQuery.f7220b != null) {
                    return false;
                }
            } else if (!str.equals(busStationQuery.f7220b)) {
                return false;
            }
            if (this.f7222d == busStationQuery.f7222d && this.f7221c == busStationQuery.f7221c) {
                String str2 = this.f7219a;
                if (str2 == null) {
                    if (busStationQuery.f7219a != null) {
                        return false;
                    }
                } else if (!str2.equals(busStationQuery.f7219a)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public String getCity() {
        return this.f7220b;
    }

    public int getPageNumber() {
        return this.f7222d;
    }

    public int getPageSize() {
        return this.f7221c;
    }

    public String getQueryString() {
        return this.f7219a;
    }

    public int hashCode() {
        String str = this.f7220b;
        int hashCode = ((((((str == null ? 0 : str.hashCode()) + 31) * 31) + this.f7222d) * 31) + this.f7221c) * 31;
        String str2 = this.f7219a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.f7220b = str;
    }

    public void setPageNumber(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f7222d = i;
    }

    public void setPageSize(int i) {
        this.f7221c = i;
    }

    public void setQueryString(String str) {
        this.f7219a = str;
    }

    public boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        String str = this.f7220b;
        if (str == null) {
            if (busStationQuery.f7220b != null) {
                return false;
            }
        } else if (!str.equals(busStationQuery.f7220b)) {
            return false;
        }
        if (this.f7221c != busStationQuery.f7221c) {
            return false;
        }
        String str2 = this.f7219a;
        if (str2 == null) {
            if (busStationQuery.f7219a != null) {
                return false;
            }
        } else if (!str2.equals(busStationQuery.f7219a)) {
            return false;
        }
        return true;
    }

    /* renamed from: clone */
    public BusStationQuery m60111clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f7219a, this.f7220b);
        busStationQuery.setPageNumber(this.f7222d);
        busStationQuery.setPageSize(this.f7221c);
        return busStationQuery;
    }
}
