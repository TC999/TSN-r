package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RideRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResultV2> CREATOR = new Parcelable.Creator<RideRouteResultV2>() { // from class: com.amap.api.services.route.RideRouteResultV2.1
        /* renamed from: a */
        private static RideRouteResultV2 m51802a(Parcel parcel) {
            return new RideRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResultV2 createFromParcel(Parcel parcel) {
            return m51802a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResultV2[] newArray(int i) {
            return m51803a(i);
        }

        /* renamed from: a */
        private static RideRouteResultV2[] m51803a(int i) {
            return new RideRouteResultV2[i];
        }
    };

    /* renamed from: a */
    private List<RidePath> f7685a;

    /* renamed from: b */
    private RouteSearchV2.RideRouteQuery f7686b;

    public RideRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f7685a = new ArrayList();
        this.f7685a = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f7686b = (RouteSearchV2.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f7685a;
    }

    public RouteSearchV2.RideRouteQuery getRideQuery() {
        return this.f7686b;
    }

    public void setPaths(List<RidePath> list) {
        this.f7685a = list;
    }

    public void setRideQuery(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        this.f7686b = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f7685a);
        parcel.writeParcelable(this.f7686b, i);
    }

    public RideRouteResultV2() {
        this.f7685a = new ArrayList();
    }
}
