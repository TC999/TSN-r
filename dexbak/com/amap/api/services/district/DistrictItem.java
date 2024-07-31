package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.services.district.DistrictItem.1
        /* renamed from: a */
        private static DistrictItem m51881a(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel parcel) {
            return m51881a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem[] newArray(int i) {
            return m51882a(i);
        }

        /* renamed from: a */
        private static DistrictItem[] m51882a(int i) {
            return new DistrictItem[i];
        }
    };

    /* renamed from: a */
    private String f7324a;

    /* renamed from: b */
    private String f7325b;

    /* renamed from: c */
    private String f7326c;

    /* renamed from: d */
    private LatLonPoint f7327d;

    /* renamed from: e */
    private String f7328e;

    /* renamed from: f */
    private List<DistrictItem> f7329f;

    /* renamed from: g */
    private String[] f7330g;

    public DistrictItem() {
        this.f7329f = new ArrayList();
        this.f7330g = new String[0];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String[] districtBoundary() {
        return this.f7330g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DistrictItem.class == obj.getClass()) {
            DistrictItem districtItem = (DistrictItem) obj;
            String str = this.f7325b;
            if (str == null) {
                if (districtItem.f7325b != null) {
                    return false;
                }
            } else if (!str.equals(districtItem.f7325b)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f7327d;
            if (latLonPoint == null) {
                if (districtItem.f7327d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(districtItem.f7327d)) {
                return false;
            }
            String str2 = this.f7324a;
            if (str2 == null) {
                if (districtItem.f7324a != null) {
                    return false;
                }
            } else if (!str2.equals(districtItem.f7324a)) {
                return false;
            }
            if (Arrays.equals(this.f7330g, districtItem.f7330g)) {
                List<DistrictItem> list = this.f7329f;
                if (list == null) {
                    if (districtItem.f7329f != null) {
                        return false;
                    }
                } else if (!list.equals(districtItem.f7329f)) {
                    return false;
                }
                String str3 = this.f7328e;
                if (str3 == null) {
                    if (districtItem.f7328e != null) {
                        return false;
                    }
                } else if (!str3.equals(districtItem.f7328e)) {
                    return false;
                }
                String str4 = this.f7326c;
                if (str4 == null) {
                    if (districtItem.f7326c != null) {
                        return false;
                    }
                } else if (!str4.equals(districtItem.f7326c)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final String getAdcode() {
        return this.f7325b;
    }

    public final LatLonPoint getCenter() {
        return this.f7327d;
    }

    public final String getCitycode() {
        return this.f7324a;
    }

    public final String getLevel() {
        return this.f7328e;
    }

    public final String getName() {
        return this.f7326c;
    }

    public final List<DistrictItem> getSubDistrict() {
        return this.f7329f;
    }

    public final int hashCode() {
        String str = this.f7325b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f7327d;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.f7324a;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Arrays.hashCode(this.f7330g)) * 31;
        List<DistrictItem> list = this.f7329f;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.f7328e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f7326c;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAdcode(String str) {
        this.f7325b = str;
    }

    public final void setCenter(LatLonPoint latLonPoint) {
        this.f7327d = latLonPoint;
    }

    public final void setCitycode(String str) {
        this.f7324a = str;
    }

    public final void setDistrictBoundary(String[] strArr) {
        this.f7330g = strArr;
    }

    public final void setLevel(String str) {
        this.f7328e = str;
    }

    public final void setName(String str) {
        this.f7326c = str;
    }

    public final void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f7329f = arrayList;
    }

    public final String toString() {
        return "DistrictItem [mCitycode=" + this.f7324a + ", mAdcode=" + this.f7325b + ", mName=" + this.f7326c + ", mCenter=" + this.f7327d + ", mLevel=" + this.f7328e + ", mDistricts=" + this.f7329f + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7324a);
        parcel.writeString(this.f7325b);
        parcel.writeString(this.f7326c);
        parcel.writeParcelable(this.f7327d, i);
        parcel.writeString(this.f7328e);
        parcel.writeTypedList(this.f7329f);
        parcel.writeInt(this.f7330g.length);
        parcel.writeStringArray(this.f7330g);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f7329f = new ArrayList();
        this.f7330g = new String[0];
        this.f7326c = str;
        this.f7324a = str2;
        this.f7325b = str3;
        this.f7327d = latLonPoint;
        this.f7328e = str4;
    }

    public DistrictItem(Parcel parcel) {
        this.f7329f = new ArrayList();
        this.f7330g = new String[0];
        this.f7324a = parcel.readString();
        this.f7325b = parcel.readString();
        this.f7326c = parcel.readString();
        this.f7327d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7328e = parcel.readString();
        this.f7329f = parcel.createTypedArrayList(CREATOR);
        String[] strArr = new String[parcel.readInt()];
        this.f7330g = strArr;
        parcel.readStringArray(strArr);
    }
}
