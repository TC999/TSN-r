package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DistanceResult implements Parcelable {
    public static final Parcelable.Creator<DistanceResult> CREATOR = new Parcelable.Creator<DistanceResult>() { // from class: com.amap.api.services.route.DistanceResult.1
        /* renamed from: a */
        private static DistanceResult m51830a(Parcel parcel) {
            return new DistanceResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult createFromParcel(Parcel parcel) {
            return m51830a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceResult[] newArray(int i) {
            return m51831a(i);
        }

        /* renamed from: a */
        private static DistanceResult[] m51831a(int i) {
            return new DistanceResult[i];
        }
    };

    /* renamed from: a */
    private DistanceSearch.DistanceQuery f7597a;

    /* renamed from: b */
    private List<DistanceItem> f7598b;

    public DistanceResult() {
        this.f7598b = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DistanceSearch.DistanceQuery getDistanceQuery() {
        return this.f7597a;
    }

    public List<DistanceItem> getDistanceResults() {
        return this.f7598b;
    }

    public void setDistanceQuery(DistanceSearch.DistanceQuery distanceQuery) {
        this.f7597a = distanceQuery;
    }

    public void setDistanceResults(List<DistanceItem> list) {
        this.f7598b = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f7598b);
    }

    protected DistanceResult(Parcel parcel) {
        this.f7598b = null;
        this.f7598b = parcel.createTypedArrayList(DistanceItem.CREATOR);
    }
}
