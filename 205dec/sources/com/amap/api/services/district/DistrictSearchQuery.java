package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new Parcelable.Creator<DistrictSearchQuery>() { // from class: com.amap.api.services.district.DistrictSearchQuery.1
        private static DistrictSearchQuery a(Parcel parcel) {
            DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
            districtSearchQuery.setKeywords(parcel.readString());
            districtSearchQuery.setKeywordsLevel(parcel.readString());
            districtSearchQuery.setPageNum(parcel.readInt());
            districtSearchQuery.setPageSize(parcel.readInt());
            districtSearchQuery.setShowChild(parcel.readByte() == 1);
            districtSearchQuery.setShowBoundary(parcel.readByte() == 1);
            districtSearchQuery.setShowBusinessArea(parcel.readByte() == 1);
            districtSearchQuery.setSubDistrict(parcel.readInt());
            return districtSearchQuery;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictSearchQuery createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictSearchQuery[] newArray(int i4) {
            return a(i4);
        }

        private static DistrictSearchQuery[] a(int i4) {
            return new DistrictSearchQuery[i4];
        }
    };
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";

    /* renamed from: a  reason: collision with root package name */
    private int f11031a;

    /* renamed from: b  reason: collision with root package name */
    private int f11032b;

    /* renamed from: c  reason: collision with root package name */
    private String f11033c;

    /* renamed from: d  reason: collision with root package name */
    private String f11034d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11035e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11036f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11037g;

    /* renamed from: h  reason: collision with root package name */
    private int f11038h;

    public DistrictSearchQuery() {
        this.f11031a = 1;
        this.f11032b = 20;
        this.f11035e = true;
        this.f11036f = false;
        this.f11037g = false;
        this.f11038h = 1;
    }

    public boolean checkKeyWords() {
        String str = this.f11033c;
        return (str == null || str.trim().equalsIgnoreCase("")) ? false : true;
    }

    public boolean checkLevels() {
        String str = this.f11034d;
        if (str == null) {
            return false;
        }
        return str.trim().equals("country") || this.f11034d.trim().equals("province") || this.f11034d.trim().equals("city") || this.f11034d.trim().equals("district") || this.f11034d.trim().equals("biz_area");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
            if (this.f11037g != districtSearchQuery.f11037g) {
                return false;
            }
            String str = this.f11033c;
            if (str == null) {
                if (districtSearchQuery.f11033c != null) {
                    return false;
                }
            } else if (!str.equals(districtSearchQuery.f11033c)) {
                return false;
            }
            return this.f11031a == districtSearchQuery.f11031a && this.f11032b == districtSearchQuery.f11032b && this.f11035e == districtSearchQuery.f11035e && this.f11038h == districtSearchQuery.f11038h;
        }
        return false;
    }

    public String getKeywords() {
        return this.f11033c;
    }

    public String getKeywordsLevel() {
        return this.f11034d;
    }

    public int getPageNum() {
        int i4 = this.f11031a;
        if (i4 <= 0) {
            return 1;
        }
        return i4;
    }

    public int getPageSize() {
        return this.f11032b;
    }

    public int getSubDistrict() {
        return this.f11038h;
    }

    public int hashCode() {
        int i4 = ((this.f11037g ? 1231 : 1237) + 31) * 31;
        String str = this.f11033c;
        int hashCode = (i4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f11034d;
        return ((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f11031a) * 31) + this.f11032b) * 31) + (this.f11035e ? 1231 : 1237)) * 31) + this.f11038h;
    }

    public boolean isShowBoundary() {
        return this.f11037g;
    }

    public boolean isShowBusinessArea() {
        return this.f11036f;
    }

    public boolean isShowChild() {
        return this.f11035e;
    }

    public void setKeywords(String str) {
        this.f11033c = str;
    }

    public void setKeywordsLevel(String str) {
        this.f11034d = str;
    }

    public void setPageNum(int i4) {
        this.f11031a = i4;
    }

    public void setPageSize(int i4) {
        this.f11032b = i4;
    }

    public void setShowBoundary(boolean z3) {
        this.f11037g = z3;
    }

    public void setShowBusinessArea(boolean z3) {
        this.f11036f = z3;
    }

    public void setShowChild(boolean z3) {
        this.f11035e = z3;
    }

    public void setSubDistrict(int i4) {
        this.f11038h = i4;
    }

    public boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        String str = this.f11033c;
        if (str == null) {
            if (districtSearchQuery.f11033c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f11033c)) {
            return false;
        }
        return this.f11032b == districtSearchQuery.f11032b && this.f11035e == districtSearchQuery.f11035e && this.f11037g == districtSearchQuery.f11037g && this.f11038h == districtSearchQuery.f11038h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11033c);
        parcel.writeString(this.f11034d);
        parcel.writeInt(this.f11031a);
        parcel.writeInt(this.f11032b);
        parcel.writeByte(this.f11035e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f11037g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f11036f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f11038h);
    }

    /* renamed from: clone */
    public DistrictSearchQuery m35clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e4) {
            j4.i(e4, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(this.f11033c);
        districtSearchQuery.setKeywordsLevel(this.f11034d);
        districtSearchQuery.setPageNum(this.f11031a);
        districtSearchQuery.setPageSize(this.f11032b);
        districtSearchQuery.setShowChild(this.f11035e);
        districtSearchQuery.setSubDistrict(this.f11038h);
        districtSearchQuery.setShowBoundary(this.f11037g);
        districtSearchQuery.setShowBusinessArea(this.f11036f);
        return districtSearchQuery;
    }

    public DistrictSearchQuery(String str, String str2, int i4) {
        this.f11032b = 20;
        this.f11035e = true;
        this.f11036f = false;
        this.f11037g = false;
        this.f11038h = 1;
        this.f11033c = str;
        this.f11034d = str2;
        this.f11031a = i4;
    }

    public DistrictSearchQuery(String str, String str2, int i4, boolean z3, int i5) {
        this(str, str2, i4);
        this.f11035e = z3;
        this.f11032b = i5;
    }
}
