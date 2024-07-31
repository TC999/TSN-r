package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RideRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResult> CREATOR = new Parcelable.Creator<RideRouteResult>() { // from class: com.amap.api.services.route.RideRouteResult.1
        /* renamed from: a */
        private static RideRouteResult m51804a(Parcel parcel) {
            return new RideRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResult createFromParcel(Parcel parcel) {
            return m51804a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResult[] newArray(int i) {
            return m51805a(i);
        }

        /* renamed from: a */
        private static RideRouteResult[] m51805a(int i) {
            return new RideRouteResult[i];
        }
    };

    /* renamed from: a */
    private List<RidePath> f7683a;

    /* renamed from: b */
    private RouteSearch.RideRouteQuery f7684b;

    public RideRouteResult(Parcel parcel) {
        super(parcel);
        this.f7683a = new ArrayList();
        this.f7683a = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f7684b = (RouteSearch.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f7683a;
    }

    public RouteSearch.RideRouteQuery getRideQuery() {
        return this.f7684b;
    }

    public void setPaths(List<RidePath> list) {
        this.f7683a = list;
    }

    public void setRideQuery(RouteSearch.RideRouteQuery rideRouteQuery) {
        this.f7684b = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f7683a);
        parcel.writeParcelable(this.f7684b, i);
    }

    public RideRouteResult() {
        this.f7683a = new ArrayList();
    }
}
