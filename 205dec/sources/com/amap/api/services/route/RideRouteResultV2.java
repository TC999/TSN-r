package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RideRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResultV2> CREATOR = new Parcelable.Creator<RideRouteResultV2>() { // from class: com.amap.api.services.route.RideRouteResultV2.1
        private static RideRouteResultV2 a(Parcel parcel) {
            return new RideRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResultV2[] newArray(int i4) {
            return a(i4);
        }

        private static RideRouteResultV2[] a(int i4) {
            return new RideRouteResultV2[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<RidePath> f11379a;

    /* renamed from: b  reason: collision with root package name */
    private RouteSearchV2.RideRouteQuery f11380b;

    public RideRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f11379a = new ArrayList();
        this.f11379a = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f11380b = (RouteSearchV2.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f11379a;
    }

    public RouteSearchV2.RideRouteQuery getRideQuery() {
        return this.f11380b;
    }

    public void setPaths(List<RidePath> list) {
        this.f11379a = list;
    }

    public void setRideQuery(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        this.f11380b = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeTypedList(this.f11379a);
        parcel.writeParcelable(this.f11380b, i4);
    }

    public RideRouteResultV2() {
        this.f11379a = new ArrayList();
    }
}
