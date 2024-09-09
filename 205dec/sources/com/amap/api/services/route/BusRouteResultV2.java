package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResultV2> CREATOR = new Parcelable.Creator<BusRouteResultV2>() { // from class: com.amap.api.services.route.BusRouteResultV2.1
        private static BusRouteResultV2 a(Parcel parcel) {
            return new BusRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2[] newArray(int i4) {
            return a(i4);
        }

        private static BusRouteResultV2[] a(int i4) {
            return new BusRouteResultV2[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f11252a;

    /* renamed from: b  reason: collision with root package name */
    private List<BusPathV2> f11253b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearchV2.BusRouteQuery f11254c;

    /* renamed from: d  reason: collision with root package name */
    private float f11255d;

    public BusRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f11253b = new ArrayList();
        this.f11252a = parcel.readFloat();
        this.f11253b = parcel.createTypedArrayList(BusPathV2.CREATOR);
        this.f11254c = (RouteSearchV2.BusRouteQuery) parcel.readParcelable(RouteSearchV2.BusRouteQuery.class.getClassLoader());
        this.f11255d = parcel.readFloat();
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.BusRouteQuery getBusQuery() {
        return this.f11254c;
    }

    public float getDistance() {
        return this.f11255d;
    }

    public List<BusPathV2> getPaths() {
        return this.f11253b;
    }

    public float getTaxiCost() {
        return this.f11252a;
    }

    public void setBusQuery(RouteSearchV2.BusRouteQuery busRouteQuery) {
        this.f11254c = busRouteQuery;
    }

    public void setDistance(float f4) {
        this.f11255d = f4;
    }

    public void setPaths(List<BusPathV2> list) {
        this.f11253b = list;
    }

    public void setTaxiCost(float f4) {
        this.f11252a = f4;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeFloat(this.f11252a);
        parcel.writeTypedList(this.f11253b);
        parcel.writeParcelable(this.f11254c, i4);
        parcel.writeFloat(this.f11255d);
    }

    public BusRouteResultV2() {
        this.f11253b = new ArrayList();
    }
}
