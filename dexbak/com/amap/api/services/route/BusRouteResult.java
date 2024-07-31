package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new Parcelable.Creator<BusRouteResult>() { // from class: com.amap.api.services.route.BusRouteResult.1
        /* renamed from: a */
        private static BusRouteResult m51838a(Parcel parcel) {
            return new BusRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult createFromParcel(Parcel parcel) {
            return m51838a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult[] newArray(int i) {
            return m51839a(i);
        }

        /* renamed from: a */
        private static BusRouteResult[] m51839a(int i) {
            return new BusRouteResult[i];
        }
    };

    /* renamed from: a */
    private float f7555a;

    /* renamed from: b */
    private List<BusPath> f7556b;

    /* renamed from: c */
    private RouteSearch.BusRouteQuery f7557c;

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f7556b = new ArrayList();
        this.f7555a = parcel.readFloat();
        this.f7556b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f7557c = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.f7557c;
    }

    public List<BusPath> getPaths() {
        return this.f7556b;
    }

    public float getTaxiCost() {
        return this.f7555a;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.f7557c = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.f7556b = list;
    }

    public void setTaxiCost(float f) {
        this.f7555a = f;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f7555a);
        parcel.writeTypedList(this.f7556b);
        parcel.writeParcelable(this.f7557c, i);
    }

    public BusRouteResult() {
        this.f7556b = new ArrayList();
    }
}
