package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p047s.C2082j4;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new Parcelable.Creator<DistrictSearchQuery>() { // from class: com.amap.api.services.district.DistrictSearchQuery.1
        /* renamed from: a */
        private static DistrictSearchQuery m51877a(Parcel parcel) {
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
            return m51877a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictSearchQuery[] newArray(int i) {
            return m51878a(i);
        }

        /* renamed from: a */
        private static DistrictSearchQuery[] m51878a(int i) {
            return new DistrictSearchQuery[i];
        }
    };
    public static final String KEYWORDS_BUSINESS = "biz_area";
    public static final String KEYWORDS_CITY = "city";
    public static final String KEYWORDS_COUNTRY = "country";
    public static final String KEYWORDS_DISTRICT = "district";
    public static final String KEYWORDS_PROVINCE = "province";

    /* renamed from: a */
    private int f7337a;

    /* renamed from: b */
    private int f7338b;

    /* renamed from: c */
    private String f7339c;

    /* renamed from: d */
    private String f7340d;

    /* renamed from: e */
    private boolean f7341e;

    /* renamed from: f */
    private boolean f7342f;

    /* renamed from: g */
    private boolean f7343g;

    /* renamed from: h */
    private int f7344h;

    public DistrictSearchQuery() {
        this.f7337a = 1;
        this.f7338b = 20;
        this.f7341e = true;
        this.f7342f = false;
        this.f7343g = false;
        this.f7344h = 1;
    }

    public boolean checkKeyWords() {
        String str = this.f7339c;
        return (str == null || str.trim().equalsIgnoreCase("")) ? false : true;
    }

    public boolean checkLevels() {
        String str = this.f7340d;
        if (str == null) {
            return false;
        }
        return str.trim().equals("country") || this.f7340d.trim().equals(KEYWORDS_PROVINCE) || this.f7340d.trim().equals(KEYWORDS_CITY) || this.f7340d.trim().equals(KEYWORDS_DISTRICT) || this.f7340d.trim().equals(KEYWORDS_BUSINESS);
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
            if (this.f7343g != districtSearchQuery.f7343g) {
                return false;
            }
            String str = this.f7339c;
            if (str == null) {
                if (districtSearchQuery.f7339c != null) {
                    return false;
                }
            } else if (!str.equals(districtSearchQuery.f7339c)) {
                return false;
            }
            return this.f7337a == districtSearchQuery.f7337a && this.f7338b == districtSearchQuery.f7338b && this.f7341e == districtSearchQuery.f7341e && this.f7344h == districtSearchQuery.f7344h;
        }
        return false;
    }

    public String getKeywords() {
        return this.f7339c;
    }

    public String getKeywordsLevel() {
        return this.f7340d;
    }

    public int getPageNum() {
        int i = this.f7337a;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public int getPageSize() {
        return this.f7338b;
    }

    public int getSubDistrict() {
        return this.f7344h;
    }

    public int hashCode() {
        int i = ((this.f7343g ? 1231 : 1237) + 31) * 31;
        String str = this.f7339c;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f7340d;
        return ((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f7337a) * 31) + this.f7338b) * 31) + (this.f7341e ? 1231 : 1237)) * 31) + this.f7344h;
    }

    public boolean isShowBoundary() {
        return this.f7343g;
    }

    public boolean isShowBusinessArea() {
        return this.f7342f;
    }

    public boolean isShowChild() {
        return this.f7341e;
    }

    public void setKeywords(String str) {
        this.f7339c = str;
    }

    public void setKeywordsLevel(String str) {
        this.f7340d = str;
    }

    public void setPageNum(int i) {
        this.f7337a = i;
    }

    public void setPageSize(int i) {
        this.f7338b = i;
    }

    public void setShowBoundary(boolean z) {
        this.f7343g = z;
    }

    public void setShowBusinessArea(boolean z) {
        this.f7342f = z;
    }

    public void setShowChild(boolean z) {
        this.f7341e = z;
    }

    public void setSubDistrict(int i) {
        this.f7344h = i;
    }

    public boolean weakEquals(DistrictSearchQuery districtSearchQuery) {
        if (this == districtSearchQuery) {
            return true;
        }
        if (districtSearchQuery == null) {
            return false;
        }
        String str = this.f7339c;
        if (str == null) {
            if (districtSearchQuery.f7339c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f7339c)) {
            return false;
        }
        return this.f7338b == districtSearchQuery.f7338b && this.f7341e == districtSearchQuery.f7341e && this.f7343g == districtSearchQuery.f7343g && this.f7344h == districtSearchQuery.f7344h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7339c);
        parcel.writeString(this.f7340d);
        parcel.writeInt(this.f7337a);
        parcel.writeInt(this.f7338b);
        parcel.writeByte(this.f7341e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7343g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7342f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f7344h);
    }

    /* renamed from: clone */
    public DistrictSearchQuery m60114clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            C2082j4.m52825i(e, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.setKeywords(this.f7339c);
        districtSearchQuery.setKeywordsLevel(this.f7340d);
        districtSearchQuery.setPageNum(this.f7337a);
        districtSearchQuery.setPageSize(this.f7338b);
        districtSearchQuery.setShowChild(this.f7341e);
        districtSearchQuery.setSubDistrict(this.f7344h);
        districtSearchQuery.setShowBoundary(this.f7343g);
        districtSearchQuery.setShowBusinessArea(this.f7342f);
        return districtSearchQuery;
    }

    public DistrictSearchQuery(String str, String str2, int i) {
        this.f7338b = 20;
        this.f7341e = true;
        this.f7342f = false;
        this.f7343g = false;
        this.f7344h = 1;
        this.f7339c = str;
        this.f7340d = str2;
        this.f7337a = i;
    }

    public DistrictSearchQuery(String str, String str2, int i, boolean z, int i2) {
        this(str, str2, i);
        this.f7341e = z;
        this.f7338b = i2;
    }
}
