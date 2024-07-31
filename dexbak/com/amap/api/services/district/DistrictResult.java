package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;

    /* renamed from: a */
    private DistrictSearchQuery f7331a;

    /* renamed from: b */
    private ArrayList<DistrictItem> f7332b;

    /* renamed from: c */
    private int f7333c;

    /* renamed from: d */
    private AMapException f7334d;

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f7332b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            /* renamed from: a */
            private static DistrictResult m51879a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return m51879a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i) {
                return m51880a(i);
            }

            /* renamed from: a */
            private static DistrictResult[] m51880a(int i) {
                return new DistrictResult[i];
            }
        };
        this.f7331a = districtSearchQuery;
        this.f7332b = arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DistrictResult.class == obj.getClass()) {
            DistrictResult districtResult = (DistrictResult) obj;
            DistrictSearchQuery districtSearchQuery = this.f7331a;
            if (districtSearchQuery == null) {
                if (districtResult.f7331a != null) {
                    return false;
                }
            } else if (!districtSearchQuery.equals(districtResult.f7331a)) {
                return false;
            }
            ArrayList<DistrictItem> arrayList = this.f7332b;
            if (arrayList == null) {
                if (districtResult.f7332b != null) {
                    return false;
                }
            } else if (!arrayList.equals(districtResult.f7332b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final AMapException getAMapException() {
        return this.f7334d;
    }

    public final ArrayList<DistrictItem> getDistrict() {
        return this.f7332b;
    }

    public final int getPageCount() {
        return this.f7333c;
    }

    public final DistrictSearchQuery getQuery() {
        return this.f7331a;
    }

    public final int hashCode() {
        DistrictSearchQuery districtSearchQuery = this.f7331a;
        int hashCode = ((districtSearchQuery == null ? 0 : districtSearchQuery.hashCode()) + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.f7332b;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setAMapException(AMapException aMapException) {
        this.f7334d = aMapException;
    }

    public final void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.f7332b = arrayList;
    }

    public final void setPageCount(int i) {
        this.f7333c = i;
    }

    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f7331a = districtSearchQuery;
    }

    public final String toString() {
        return "DistrictResult [mDisQuery=" + this.f7331a + ", mDistricts=" + this.f7332b + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7331a, i);
        parcel.writeTypedList(this.f7332b);
    }

    public DistrictResult() {
        this.f7332b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            /* renamed from: a */
            private static DistrictResult m51879a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return m51879a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i) {
                return m51880a(i);
            }

            /* renamed from: a */
            private static DistrictResult[] m51880a(int i) {
                return new DistrictResult[i];
            }
        };
    }

    protected DistrictResult(Parcel parcel) {
        this.f7332b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            /* renamed from: a */
            private static DistrictResult m51879a(Parcel parcel2) {
                return new DistrictResult(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel2) {
                return m51879a(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i) {
                return m51880a(i);
            }

            /* renamed from: a */
            private static DistrictResult[] m51880a(int i) {
                return new DistrictResult[i];
            }
        };
        this.f7331a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f7332b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }
}
