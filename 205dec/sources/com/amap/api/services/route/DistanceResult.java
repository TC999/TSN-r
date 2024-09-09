package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DistanceResult implements Parcelable {
    public static final Parcelable.Creator<DistanceResult> CREATOR = new Parcelable.Creator<DistanceResult>() { // from class: com.amap.api.services.route.DistanceResult.1
        private static DistanceResult a(Parcel parcel) {
            return new DistanceResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult[] newArray(int i4) {
            return a(i4);
        }

        private static DistanceResult[] a(int i4) {
            return new DistanceResult[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private DistanceSearch.DistanceQuery f11291a;

    /* renamed from: b  reason: collision with root package name */
    private List<DistanceItem> f11292b;

    public DistanceResult() {
        this.f11292b = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.f11291a;
    }

    public List<DistanceItem> getDistanceResults() {
        return this.f11292b;
    }

    public void setDistanceQuery(DistanceSearch.DistanceQuery distanceQuery) {
        this.f11291a = distanceQuery;
    }

    public void setDistanceResults(List<DistanceItem> list) {
        this.f11292b = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.f11292b);
    }

    protected DistanceResult(Parcel parcel) {
        this.f11292b = null;
        this.f11292b = parcel.createTypedArrayList(DistanceItem.CREATOR);
    }
}
