package com.amap.api.services.busline;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusLineQuery implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f10896a;

    /* renamed from: b  reason: collision with root package name */
    private String f10897b;

    /* renamed from: e  reason: collision with root package name */
    private SearchType f10900e;

    /* renamed from: c  reason: collision with root package name */
    private int f10898c = 20;

    /* renamed from: d  reason: collision with root package name */
    private int f10899d = 1;

    /* renamed from: f  reason: collision with root package name */
    private String f10901f = "base";

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f10896a = str;
        this.f10900e = searchType;
        this.f10897b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusLineQuery busLineQuery = (BusLineQuery) obj;
            if (this.f10900e != busLineQuery.f10900e) {
                return false;
            }
            String str = this.f10897b;
            if (str == null) {
                if (busLineQuery.f10897b != null) {
                    return false;
                }
            } else if (!str.equals(busLineQuery.f10897b)) {
                return false;
            }
            if (this.f10899d == busLineQuery.f10899d && this.f10898c == busLineQuery.f10898c) {
                String str2 = this.f10896a;
                if (str2 == null) {
                    if (busLineQuery.f10896a != null) {
                        return false;
                    }
                } else if (!str2.equals(busLineQuery.f10896a)) {
                    return false;
                }
                String str3 = this.f10901f;
                if (str3 == null) {
                    if (busLineQuery.f10901f != null) {
                        return false;
                    }
                } else if (!str3.equals(busLineQuery.f10901f)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public SearchType getCategory() {
        return this.f10900e;
    }

    public String getCity() {
        return this.f10897b;
    }

    public String getExtensions() {
        return this.f10901f;
    }

    public int getPageNumber() {
        return this.f10899d;
    }

    public int getPageSize() {
        return this.f10898c;
    }

    public String getQueryString() {
        return this.f10896a;
    }

    public int hashCode() {
        SearchType searchType = this.f10900e;
        int hashCode = ((searchType == null ? 0 : searchType.hashCode()) + 31) * 31;
        String str = this.f10897b;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f10899d) * 31) + this.f10898c) * 31;
        String str2 = this.f10896a;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f10901f;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setCategory(SearchType searchType) {
        this.f10900e = searchType;
    }

    public void setCity(String str) {
        this.f10897b = str;
    }

    public void setExtensions(String str) {
        this.f10901f = str;
    }

    public void setPageNumber(int i4) {
        if (i4 <= 0) {
            i4 = 1;
        }
        this.f10899d = i4;
    }

    public void setPageSize(int i4) {
        this.f10898c = i4;
    }

    public void setQueryString(String str) {
        this.f10896a = str;
    }

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.f10896a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.f10896a)) {
            return false;
        }
        if (this.f10897b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.f10897b)) {
            return false;
        }
        return this.f10898c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.f10900e) == 0;
    }

    /* renamed from: clone */
    public BusLineQuery m31clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f10896a, this.f10900e, this.f10897b);
        busLineQuery.setPageNumber(this.f10899d);
        busLineQuery.setPageSize(this.f10898c);
        busLineQuery.setExtensions(this.f10901f);
        return busLineQuery;
    }
}
