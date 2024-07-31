package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusRouteResultV2 extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResultV2> CREATOR = new Parcelable.Creator<BusRouteResultV2>() { // from class: com.amap.api.services.route.BusRouteResultV2.1
        /* renamed from: a */
        private static BusRouteResultV2 m51836a(Parcel parcel) {
            return new BusRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2 createFromParcel(Parcel parcel) {
            return m51836a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2[] newArray(int i) {
            return m51837a(i);
        }

        /* renamed from: a */
        private static BusRouteResultV2[] m51837a(int i) {
            return new BusRouteResultV2[i];
        }
    };

    /* renamed from: a */
    private float f7558a;

    /* renamed from: b */
    private List<BusPathV2> f7559b;

    /* renamed from: c */
    private RouteSearchV2.BusRouteQuery f7560c;

    /* renamed from: d */
    private float f7561d;

    public BusRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f7559b = new ArrayList();
        this.f7558a = parcel.readFloat();
        this.f7559b = parcel.createTypedArrayList(BusPathV2.CREATOR);
        this.f7560c = (RouteSearchV2.BusRouteQuery) parcel.readParcelable(RouteSearchV2.BusRouteQuery.class.getClassLoader());
        this.f7561d = parcel.readFloat();
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.BusRouteQuery getBusQuery() {
        return this.f7560c;
    }

    public float getDistance() {
        return this.f7561d;
    }

    public List<BusPathV2> getPaths() {
        return this.f7559b;
    }

    public float getTaxiCost() {
        return this.f7558a;
    }

    public void setBusQuery(RouteSearchV2.BusRouteQuery busRouteQuery) {
        this.f7560c = busRouteQuery;
    }

    public void setDistance(float f) {
        this.f7561d = f;
    }

    public void setPaths(List<BusPathV2> list) {
        this.f7559b = list;
    }

    public void setTaxiCost(float f) {
        this.f7558a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f7558a);
        parcel.writeTypedList(this.f7559b);
        parcel.writeParcelable(this.f7560c, i);
        parcel.writeFloat(this.f7561d);
    }

    public BusRouteResultV2() {
        this.f7559b = new ArrayList();
    }
}
