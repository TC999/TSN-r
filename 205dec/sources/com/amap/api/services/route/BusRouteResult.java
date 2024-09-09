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
public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new Parcelable.Creator<BusRouteResult>() { // from class: com.amap.api.services.route.BusRouteResult.1
        private static BusRouteResult a(Parcel parcel) {
            return new BusRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult[] newArray(int i4) {
            return a(i4);
        }

        private static BusRouteResult[] a(int i4) {
            return new BusRouteResult[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f11249a;

    /* renamed from: b  reason: collision with root package name */
    private List<BusPath> f11250b;

    /* renamed from: c  reason: collision with root package name */
    private RouteSearch.BusRouteQuery f11251c;

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f11250b = new ArrayList();
        this.f11249a = parcel.readFloat();
        this.f11250b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f11251c = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.f11251c;
    }

    public List<BusPath> getPaths() {
        return this.f11250b;
    }

    public float getTaxiCost() {
        return this.f11249a;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.f11251c = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.f11250b = list;
    }

    public void setTaxiCost(float f4) {
        this.f11249a = f4;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeFloat(this.f11249a);
        parcel.writeTypedList(this.f11250b);
        parcel.writeParcelable(this.f11251c, i4);
    }

    public BusRouteResult() {
        this.f11250b = new ArrayList();
    }
}
