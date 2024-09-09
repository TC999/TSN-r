package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = new Parcelable.Creator<RouteResult>() { // from class: com.amap.api.services.route.RouteResult.1
        private static RouteResult a(Parcel parcel) {
            return new RouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteResult[] newArray(int i4) {
            return a(i4);
        }

        private static RouteResult[] a(int i4) {
            return new RouteResult[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f11409a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11410b;

    public RouteResult(Parcel parcel) {
        this.f11409a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11410b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f11409a;
    }

    public LatLonPoint getTargetPos() {
        return this.f11410b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f11409a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f11410b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f11409a, i4);
        parcel.writeParcelable(this.f11410b, i4);
    }

    public RouteResult() {
    }
}
