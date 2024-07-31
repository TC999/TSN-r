package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusStep implements Parcelable {
    public static final Parcelable.Creator<BusStep> CREATOR = new Parcelable.Creator<BusStep>() { // from class: com.amap.api.services.route.BusStep.1
        /* renamed from: a */
        private static BusStep m51835a(Parcel parcel) {
            return new BusStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStep createFromParcel(Parcel parcel) {
            return m51835a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStep[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private RouteBusWalkItem f7562a;

    /* renamed from: b */
    private List<RouteBusLineItem> f7563b;

    /* renamed from: c */
    private Doorway f7564c;

    /* renamed from: d */
    private Doorway f7565d;

    /* renamed from: e */
    private RouteRailwayItem f7566e;

    /* renamed from: f */
    private TaxiItem f7567f;

    public BusStep(Parcel parcel) {
        this.f7563b = new ArrayList();
        this.f7562a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f7563b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f7564c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f7565d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f7566e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f7567f = (TaxiItem) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f7563b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f7563b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f7563b;
    }

    public Doorway getEntrance() {
        return this.f7564c;
    }

    public Doorway getExit() {
        return this.f7565d;
    }

    public RouteRailwayItem getRailway() {
        return this.f7566e;
    }

    public TaxiItem getTaxi() {
        return this.f7567f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f7562a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f7563b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f7563b.add(routeBusLineItem);
        }
        this.f7563b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f7563b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f7564c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f7565d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f7566e = routeRailwayItem;
    }

    public void setTaxi(TaxiItem taxiItem) {
        this.f7567f = taxiItem;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f7562a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7562a, i);
        parcel.writeTypedList(this.f7563b);
        parcel.writeParcelable(this.f7564c, i);
        parcel.writeParcelable(this.f7565d, i);
        parcel.writeParcelable(this.f7566e, i);
        parcel.writeParcelable(this.f7567f, i);
    }

    public BusStep() {
        this.f7563b = new ArrayList();
    }
}
