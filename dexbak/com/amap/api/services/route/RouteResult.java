package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = new Parcelable.Creator<RouteResult>() { // from class: com.amap.api.services.route.RouteResult.1
        /* renamed from: a */
        private static RouteResult m51792a(Parcel parcel) {
            return new RouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteResult createFromParcel(Parcel parcel) {
            return m51792a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteResult[] newArray(int i) {
            return m51793a(i);
        }

        /* renamed from: a */
        private static RouteResult[] m51793a(int i) {
            return new RouteResult[i];
        }
    };

    /* renamed from: a */
    private LatLonPoint f7715a;

    /* renamed from: b */
    private LatLonPoint f7716b;

    public RouteResult(Parcel parcel) {
        this.f7715a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7716b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f7715a;
    }

    public LatLonPoint getTargetPos() {
        return this.f7716b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f7715a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f7716b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7715a, i);
        parcel.writeParcelable(this.f7716b, i);
    }

    public RouteResult() {
    }
}
