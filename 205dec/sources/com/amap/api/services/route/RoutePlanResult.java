package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = new Parcelable.Creator<RoutePlanResult>() { // from class: com.amap.api.services.route.RoutePlanResult.1
        private static RoutePlanResult a(Parcel parcel) {
            return new RoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult[] newArray(int i4) {
            return a(i4);
        }

        private static RoutePlanResult[] a(int i4) {
            return new RoutePlanResult[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f11398a;

    /* renamed from: b  reason: collision with root package name */
    private LatLonPoint f11399b;

    public RoutePlanResult(Parcel parcel) {
        this.f11398a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11399b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f11398a;
    }

    public LatLonPoint getTargetPos() {
        return this.f11399b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f11398a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f11399b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f11398a, i4);
        parcel.writeParcelable(this.f11399b, i4);
    }

    public RoutePlanResult() {
    }
}
