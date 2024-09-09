package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusStepV2 implements Parcelable {
    public static final Parcelable.Creator<BusStepV2> CREATOR = new Parcelable.Creator<BusStepV2>() { // from class: com.amap.api.services.route.BusStepV2.1
        private static BusStepV2 a(Parcel parcel) {
            return new BusStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStepV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStepV2[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private RouteBusWalkItem f11262a;

    /* renamed from: b  reason: collision with root package name */
    private List<RouteBusLineItem> f11263b;

    /* renamed from: c  reason: collision with root package name */
    private Doorway f11264c;

    /* renamed from: d  reason: collision with root package name */
    private Doorway f11265d;

    /* renamed from: e  reason: collision with root package name */
    private RouteRailwayItem f11266e;

    /* renamed from: f  reason: collision with root package name */
    private TaxiItemV2 f11267f;

    public BusStepV2(Parcel parcel) {
        this.f11263b = new ArrayList();
        this.f11262a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f11263b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f11264c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f11265d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f11266e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f11267f = (TaxiItemV2) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f11263b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f11263b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f11263b;
    }

    public Doorway getEntrance() {
        return this.f11264c;
    }

    public Doorway getExit() {
        return this.f11265d;
    }

    public RouteRailwayItem getRailway() {
        return this.f11266e;
    }

    public TaxiItemV2 getTaxi() {
        return this.f11267f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f11262a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f11263b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f11263b.add(routeBusLineItem);
        }
        this.f11263b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f11263b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f11264c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f11265d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f11266e = routeRailwayItem;
    }

    public void setTaxi(TaxiItemV2 taxiItemV2) {
        this.f11267f = taxiItemV2;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f11262a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f11262a, i4);
        parcel.writeTypedList(this.f11263b);
        parcel.writeParcelable(this.f11264c, i4);
        parcel.writeParcelable(this.f11265d, i4);
        parcel.writeParcelable(this.f11266e, i4);
        parcel.writeParcelable(this.f11267f, i4);
    }

    public BusStepV2() {
        this.f11263b = new ArrayList();
    }
}
