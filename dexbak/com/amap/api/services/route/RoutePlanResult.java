package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = new Parcelable.Creator<RoutePlanResult>() { // from class: com.amap.api.services.route.RoutePlanResult.1
        /* renamed from: a */
        private static RoutePlanResult m51796a(Parcel parcel) {
            return new RoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult createFromParcel(Parcel parcel) {
            return m51796a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult[] newArray(int i) {
            return m51797a(i);
        }

        /* renamed from: a */
        private static RoutePlanResult[] m51797a(int i) {
            return new RoutePlanResult[i];
        }
    };

    /* renamed from: a */
    private LatLonPoint f7704a;

    /* renamed from: b */
    private LatLonPoint f7705b;

    public RoutePlanResult(Parcel parcel) {
        this.f7704a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7705b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f7704a;
    }

    public LatLonPoint getTargetPos() {
        return this.f7705b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f7704a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f7705b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7704a, i);
        parcel.writeParcelable(this.f7705b, i);
    }

    public RoutePlanResult() {
    }
}
