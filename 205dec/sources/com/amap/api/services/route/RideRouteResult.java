package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RideRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResult> CREATOR = new Parcelable.Creator<RideRouteResult>() { // from class: com.amap.api.services.route.RideRouteResult.1
        private static RideRouteResult a(Parcel parcel) {
            return new RideRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResult[] newArray(int i4) {
            return a(i4);
        }

        private static RideRouteResult[] a(int i4) {
            return new RideRouteResult[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<RidePath> f11377a;

    /* renamed from: b  reason: collision with root package name */
    private RouteSearch.RideRouteQuery f11378b;

    public RideRouteResult(Parcel parcel) {
        super(parcel);
        this.f11377a = new ArrayList();
        this.f11377a = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f11378b = (RouteSearch.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f11377a;
    }

    public RouteSearch.RideRouteQuery getRideQuery() {
        return this.f11378b;
    }

    public void setPaths(List<RidePath> list) {
        this.f11377a = list;
    }

    public void setRideQuery(RouteSearch.RideRouteQuery rideRouteQuery) {
        this.f11378b = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f11377a);
        parcel.writeParcelable(this.f11378b, i4);
    }

    public RideRouteResult() {
        this.f11377a = new ArrayList();
    }
}
