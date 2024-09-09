package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusStep implements Parcelable {
    public static final Parcelable.Creator<BusStep> CREATOR = new Parcelable.Creator<BusStep>() { // from class: com.amap.api.services.route.BusStep.1
        private static BusStep a(Parcel parcel) {
            return new BusStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStep[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private RouteBusWalkItem f11256a;

    /* renamed from: b  reason: collision with root package name */
    private List<RouteBusLineItem> f11257b;

    /* renamed from: c  reason: collision with root package name */
    private Doorway f11258c;

    /* renamed from: d  reason: collision with root package name */
    private Doorway f11259d;

    /* renamed from: e  reason: collision with root package name */
    private RouteRailwayItem f11260e;

    /* renamed from: f  reason: collision with root package name */
    private TaxiItem f11261f;

    public BusStep(Parcel parcel) {
        this.f11257b = new ArrayList();
        this.f11256a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f11257b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f11258c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f11259d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f11260e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f11261f = (TaxiItem) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f11257b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f11257b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f11257b;
    }

    public Doorway getEntrance() {
        return this.f11258c;
    }

    public Doorway getExit() {
        return this.f11259d;
    }

    public RouteRailwayItem getRailway() {
        return this.f11260e;
    }

    public TaxiItem getTaxi() {
        return this.f11261f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f11256a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f11257b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f11257b.add(routeBusLineItem);
        }
        this.f11257b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f11257b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f11258c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f11259d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f11260e = routeRailwayItem;
    }

    public void setTaxi(TaxiItem taxiItem) {
        this.f11261f = taxiItem;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f11256a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f11256a, i4);
        parcel.writeTypedList(this.f11257b);
        parcel.writeParcelable(this.f11258c, i4);
        parcel.writeParcelable(this.f11259d, i4);
        parcel.writeParcelable(this.f11260e, i4);
        parcel.writeParcelable(this.f11261f, i4);
    }

    public BusStep() {
        this.f11257b = new ArrayList();
    }
}
