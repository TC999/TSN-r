package com.amap.api.services.busline;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusLineQuery implements Cloneable {

    /* renamed from: a */
    private String f7200a;

    /* renamed from: b */
    private String f7201b;

    /* renamed from: e */
    private SearchType f7204e;

    /* renamed from: c */
    private int f7202c = 20;

    /* renamed from: d */
    private int f7203d = 1;

    /* renamed from: f */
    private String f7205f = "base";

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f7200a = str;
        this.f7204e = searchType;
        this.f7201b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusLineQuery busLineQuery = (BusLineQuery) obj;
            if (this.f7204e != busLineQuery.f7204e) {
                return false;
            }
            String str = this.f7201b;
            if (str == null) {
                if (busLineQuery.f7201b != null) {
                    return false;
                }
            } else if (!str.equals(busLineQuery.f7201b)) {
                return false;
            }
            if (this.f7203d == busLineQuery.f7203d && this.f7202c == busLineQuery.f7202c) {
                String str2 = this.f7200a;
                if (str2 == null) {
                    if (busLineQuery.f7200a != null) {
                        return false;
                    }
                } else if (!str2.equals(busLineQuery.f7200a)) {
                    return false;
                }
                String str3 = this.f7205f;
                if (str3 == null) {
                    if (busLineQuery.f7205f != null) {
                        return false;
                    }
                } else if (!str3.equals(busLineQuery.f7205f)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public SearchType getCategory() {
        return this.f7204e;
    }

    public String getCity() {
        return this.f7201b;
    }

    public String getExtensions() {
        return this.f7205f;
    }

    public int getPageNumber() {
        return this.f7203d;
    }

    public int getPageSize() {
        return this.f7202c;
    }

    public String getQueryString() {
        return this.f7200a;
    }

    public int hashCode() {
        SearchType searchType = this.f7204e;
        int hashCode = ((searchType == null ? 0 : searchType.hashCode()) + 31) * 31;
        String str = this.f7201b;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f7203d) * 31) + this.f7202c) * 31;
        String str2 = this.f7200a;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f7205f;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setCategory(SearchType searchType) {
        this.f7204e = searchType;
    }

    public void setCity(String str) {
        this.f7201b = str;
    }

    public void setExtensions(String str) {
        this.f7205f = str;
    }

    public void setPageNumber(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f7203d = i;
    }

    public void setPageSize(int i) {
        this.f7202c = i;
    }

    public void setQueryString(String str) {
        this.f7200a = str;
    }

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.f7200a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.f7200a)) {
            return false;
        }
        if (this.f7201b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.f7201b)) {
            return false;
        }
        return this.f7202c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.f7204e) == 0;
    }

    /* renamed from: clone */
    public BusLineQuery m60110clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f7200a, this.f7204e, this.f7201b);
        busLineQuery.setPageNumber(this.f7203d);
        busLineQuery.setPageSize(this.f7202c);
        busLineQuery.setExtensions(this.f7205f);
        return busLineQuery;
    }
}
