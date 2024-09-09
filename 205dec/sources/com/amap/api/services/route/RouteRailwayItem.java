package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RouteRailwayItem extends Railway implements Parcelable {
    public static final Parcelable.Creator<RouteRailwayItem> CREATOR = new Parcelable.Creator<RouteRailwayItem>() { // from class: com.amap.api.services.route.RouteRailwayItem.1
        private static RouteRailwayItem a(Parcel parcel) {
            return new RouteRailwayItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem[] newArray(int i4) {
            return a(i4);
        }

        private static RouteRailwayItem[] a(int i4) {
            return new RouteRailwayItem[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11400a;

    /* renamed from: b  reason: collision with root package name */
    private String f11401b;

    /* renamed from: c  reason: collision with root package name */
    private float f11402c;

    /* renamed from: d  reason: collision with root package name */
    private String f11403d;

    /* renamed from: e  reason: collision with root package name */
    private RailwayStationItem f11404e;

    /* renamed from: f  reason: collision with root package name */
    private RailwayStationItem f11405f;

    /* renamed from: g  reason: collision with root package name */
    private List<RailwayStationItem> f11406g;

    /* renamed from: h  reason: collision with root package name */
    private List<Railway> f11407h;

    /* renamed from: i  reason: collision with root package name */
    private List<RailwaySpace> f11408i;

    public RouteRailwayItem() {
        this.f11406g = new ArrayList();
        this.f11407h = new ArrayList();
        this.f11408i = new ArrayList();
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Railway> getAlters() {
        return this.f11407h;
    }

    public RailwayStationItem getArrivalstop() {
        return this.f11405f;
    }

    public RailwayStationItem getDeparturestop() {
        return this.f11404e;
    }

    public float getDistance() {
        return this.f11402c;
    }

    public List<RailwaySpace> getSpaces() {
        return this.f11408i;
    }

    public String getTime() {
        return this.f11400a;
    }

    public String getTrip() {
        return this.f11401b;
    }

    public String getType() {
        return this.f11403d;
    }

    public List<RailwayStationItem> getViastops() {
        return this.f11406g;
    }

    public void setAlters(List<Railway> list) {
        this.f11407h = list;
    }

    public void setArrivalstop(RailwayStationItem railwayStationItem) {
        this.f11405f = railwayStationItem;
    }

    public void setDeparturestop(RailwayStationItem railwayStationItem) {
        this.f11404e = railwayStationItem;
    }

    public void setDistance(float f4) {
        this.f11402c = f4;
    }

    public void setSpaces(List<RailwaySpace> list) {
        this.f11408i = list;
    }

    public void setTime(String str) {
        this.f11400a = str;
    }

    public void setTrip(String str) {
        this.f11401b = str;
    }

    public void setType(String str) {
        this.f11403d = str;
    }

    public void setViastops(List<RailwayStationItem> list) {
        this.f11406g = list;
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.f11400a);
        parcel.writeString(this.f11401b);
        parcel.writeFloat(this.f11402c);
        parcel.writeString(this.f11403d);
        parcel.writeParcelable(this.f11404e, i4);
        parcel.writeParcelable(this.f11405f, i4);
        parcel.writeTypedList(this.f11406g);
        parcel.writeTypedList(this.f11407h);
        parcel.writeTypedList(this.f11408i);
    }

    protected RouteRailwayItem(Parcel parcel) {
        super(parcel);
        this.f11406g = new ArrayList();
        this.f11407h = new ArrayList();
        this.f11408i = new ArrayList();
        this.f11400a = parcel.readString();
        this.f11401b = parcel.readString();
        this.f11402c = parcel.readFloat();
        this.f11403d = parcel.readString();
        this.f11404e = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f11405f = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f11406g = parcel.createTypedArrayList(RailwayStationItem.CREATOR);
        this.f11407h = parcel.createTypedArrayList(Railway.CREATOR);
        this.f11408i = parcel.createTypedArrayList(RailwaySpace.CREATOR);
    }
}
