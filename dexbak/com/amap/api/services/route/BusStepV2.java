package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusStepV2 implements Parcelable {
    public static final Parcelable.Creator<BusStepV2> CREATOR = new Parcelable.Creator<BusStepV2>() { // from class: com.amap.api.services.route.BusStepV2.1
        /* renamed from: a */
        private static BusStepV2 m51834a(Parcel parcel) {
            return new BusStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStepV2 createFromParcel(Parcel parcel) {
            return m51834a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStepV2[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private RouteBusWalkItem f7568a;

    /* renamed from: b */
    private List<RouteBusLineItem> f7569b;

    /* renamed from: c */
    private Doorway f7570c;

    /* renamed from: d */
    private Doorway f7571d;

    /* renamed from: e */
    private RouteRailwayItem f7572e;

    /* renamed from: f */
    private TaxiItemV2 f7573f;

    public BusStepV2(Parcel parcel) {
        this.f7569b = new ArrayList();
        this.f7568a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f7569b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f7570c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f7571d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f7572e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f7573f = (TaxiItemV2) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f7569b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f7569b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f7569b;
    }

    public Doorway getEntrance() {
        return this.f7570c;
    }

    public Doorway getExit() {
        return this.f7571d;
    }

    public RouteRailwayItem getRailway() {
        return this.f7572e;
    }

    public TaxiItemV2 getTaxi() {
        return this.f7573f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f7568a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f7569b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f7569b.add(routeBusLineItem);
        }
        this.f7569b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f7569b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f7570c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f7571d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f7572e = routeRailwayItem;
    }

    public void setTaxi(TaxiItemV2 taxiItemV2) {
        this.f7573f = taxiItemV2;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f7568a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7568a, i);
        parcel.writeTypedList(this.f7569b);
        parcel.writeParcelable(this.f7570c, i);
        parcel.writeParcelable(this.f7571d, i);
        parcel.writeParcelable(this.f7572e, i);
        parcel.writeParcelable(this.f7573f, i);
    }

    public BusStepV2() {
        this.f7569b = new ArrayList();
    }
}
