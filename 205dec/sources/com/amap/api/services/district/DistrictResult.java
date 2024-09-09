package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;

    /* renamed from: a  reason: collision with root package name */
    private DistrictSearchQuery f11025a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<DistrictItem> f11026b;

    /* renamed from: c  reason: collision with root package name */
    private int f11027c;

    /* renamed from: d  reason: collision with root package name */
    private AMapException f11028d;

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.f11026b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i4) {
                return a(i4);
            }

            private static DistrictResult[] a(int i4) {
                return new DistrictResult[i4];
            }
        };
        this.f11025a = districtSearchQuery;
        this.f11026b = arrayList;
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
            DistrictSearchQuery districtSearchQuery = this.f11025a;
            if (districtSearchQuery == null) {
                if (districtResult.f11025a != null) {
                    return false;
                }
            } else if (!districtSearchQuery.equals(districtResult.f11025a)) {
                return false;
            }
            ArrayList<DistrictItem> arrayList = this.f11026b;
            if (arrayList == null) {
                if (districtResult.f11026b != null) {
                    return false;
                }
            } else if (!arrayList.equals(districtResult.f11026b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final AMapException getAMapException() {
        return this.f11028d;
    }

    public final ArrayList<DistrictItem> getDistrict() {
        return this.f11026b;
    }

    public final int getPageCount() {
        return this.f11027c;
    }

    public final DistrictSearchQuery getQuery() {
        return this.f11025a;
    }

    public final int hashCode() {
        DistrictSearchQuery districtSearchQuery = this.f11025a;
        int hashCode = ((districtSearchQuery == null ? 0 : districtSearchQuery.hashCode()) + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.f11026b;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setAMapException(AMapException aMapException) {
        this.f11028d = aMapException;
    }

    public final void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.f11026b = arrayList;
    }

    public final void setPageCount(int i4) {
        this.f11027c = i4;
    }

    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f11025a = districtSearchQuery;
    }

    public final String toString() {
        return "DistrictResult [mDisQuery=" + this.f11025a + ", mDistricts=" + this.f11026b + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f11025a, i4);
        parcel.writeTypedList(this.f11026b);
    }

    public DistrictResult() {
        this.f11026b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i4) {
                return a(i4);
            }

            private static DistrictResult[] a(int i4) {
                return new DistrictResult[i4];
            }
        };
    }

    protected DistrictResult(Parcel parcel) {
        this.f11026b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel2) {
                return new DistrictResult(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel2) {
                return a(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i4) {
                return a(i4);
            }

            private static DistrictResult[] a(int i4) {
                return new DistrictResult[i4];
            }
        };
        this.f11025a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f11026b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }
}
