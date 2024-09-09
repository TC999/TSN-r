package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.services.district.DistrictItem.1
        private static DistrictItem a(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem[] newArray(int i4) {
            return a(i4);
        }

        private static DistrictItem[] a(int i4) {
            return new DistrictItem[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11018a;

    /* renamed from: b  reason: collision with root package name */
    private String f11019b;

    /* renamed from: c  reason: collision with root package name */
    private String f11020c;

    /* renamed from: d  reason: collision with root package name */
    private LatLonPoint f11021d;

    /* renamed from: e  reason: collision with root package name */
    private String f11022e;

    /* renamed from: f  reason: collision with root package name */
    private List<DistrictItem> f11023f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f11024g;

    public DistrictItem() {
        this.f11023f = new ArrayList();
        this.f11024g = new String[0];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String[] districtBoundary() {
        return this.f11024g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DistrictItem.class == obj.getClass()) {
            DistrictItem districtItem = (DistrictItem) obj;
            String str = this.f11019b;
            if (str == null) {
                if (districtItem.f11019b != null) {
                    return false;
                }
            } else if (!str.equals(districtItem.f11019b)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f11021d;
            if (latLonPoint == null) {
                if (districtItem.f11021d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(districtItem.f11021d)) {
                return false;
            }
            String str2 = this.f11018a;
            if (str2 == null) {
                if (districtItem.f11018a != null) {
                    return false;
                }
            } else if (!str2.equals(districtItem.f11018a)) {
                return false;
            }
            if (Arrays.equals(this.f11024g, districtItem.f11024g)) {
                List<DistrictItem> list = this.f11023f;
                if (list == null) {
                    if (districtItem.f11023f != null) {
                        return false;
                    }
                } else if (!list.equals(districtItem.f11023f)) {
                    return false;
                }
                String str3 = this.f11022e;
                if (str3 == null) {
                    if (districtItem.f11022e != null) {
                        return false;
                    }
                } else if (!str3.equals(districtItem.f11022e)) {
                    return false;
                }
                String str4 = this.f11020c;
                if (str4 == null) {
                    if (districtItem.f11020c != null) {
                        return false;
                    }
                } else if (!str4.equals(districtItem.f11020c)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final String getAdcode() {
        return this.f11019b;
    }

    public final LatLonPoint getCenter() {
        return this.f11021d;
    }

    public final String getCitycode() {
        return this.f11018a;
    }

    public final String getLevel() {
        return this.f11022e;
    }

    public final String getName() {
        return this.f11020c;
    }

    public final List<DistrictItem> getSubDistrict() {
        return this.f11023f;
    }

    public final int hashCode() {
        String str = this.f11019b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f11021d;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.f11018a;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Arrays.hashCode(this.f11024g)) * 31;
        List<DistrictItem> list = this.f11023f;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.f11022e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f11020c;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAdcode(String str) {
        this.f11019b = str;
    }

    public final void setCenter(LatLonPoint latLonPoint) {
        this.f11021d = latLonPoint;
    }

    public final void setCitycode(String str) {
        this.f11018a = str;
    }

    public final void setDistrictBoundary(String[] strArr) {
        this.f11024g = strArr;
    }

    public final void setLevel(String str) {
        this.f11022e = str;
    }

    public final void setName(String str) {
        this.f11020c = str;
    }

    public final void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f11023f = arrayList;
    }

    public final String toString() {
        return "DistrictItem [mCitycode=" + this.f11018a + ", mAdcode=" + this.f11019b + ", mName=" + this.f11020c + ", mCenter=" + this.f11021d + ", mLevel=" + this.f11022e + ", mDistricts=" + this.f11023f + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11018a);
        parcel.writeString(this.f11019b);
        parcel.writeString(this.f11020c);
        parcel.writeParcelable(this.f11021d, i4);
        parcel.writeString(this.f11022e);
        parcel.writeTypedList(this.f11023f);
        parcel.writeInt(this.f11024g.length);
        parcel.writeStringArray(this.f11024g);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f11023f = new ArrayList();
        this.f11024g = new String[0];
        this.f11020c = str;
        this.f11018a = str2;
        this.f11019b = str3;
        this.f11021d = latLonPoint;
        this.f11022e = str4;
    }

    public DistrictItem(Parcel parcel) {
        this.f11023f = new ArrayList();
        this.f11024g = new String[0];
        this.f11018a = parcel.readString();
        this.f11019b = parcel.readString();
        this.f11020c = parcel.readString();
        this.f11021d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11022e = parcel.readString();
        this.f11023f = parcel.createTypedArrayList(CREATOR);
        String[] strArr = new String[parcel.readInt()];
        this.f11024g = strArr;
        parcel.readStringArray(strArr);
    }
}
