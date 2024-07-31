package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RouteRailwayItem extends Railway implements Parcelable {
    public static final Parcelable.Creator<RouteRailwayItem> CREATOR = new Parcelable.Creator<RouteRailwayItem>() { // from class: com.amap.api.services.route.RouteRailwayItem.1
        /* renamed from: a */
        private static RouteRailwayItem m51794a(Parcel parcel) {
            return new RouteRailwayItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem createFromParcel(Parcel parcel) {
            return m51794a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem[] newArray(int i) {
            return m51795a(i);
        }

        /* renamed from: a */
        private static RouteRailwayItem[] m51795a(int i) {
            return new RouteRailwayItem[i];
        }
    };

    /* renamed from: a */
    private String f7706a;

    /* renamed from: b */
    private String f7707b;

    /* renamed from: c */
    private float f7708c;

    /* renamed from: d */
    private String f7709d;

    /* renamed from: e */
    private RailwayStationItem f7710e;

    /* renamed from: f */
    private RailwayStationItem f7711f;

    /* renamed from: g */
    private List<RailwayStationItem> f7712g;

    /* renamed from: h */
    private List<Railway> f7713h;

    /* renamed from: i */
    private List<RailwaySpace> f7714i;

    public RouteRailwayItem() {
        this.f7712g = new ArrayList();
        this.f7713h = new ArrayList();
        this.f7714i = new ArrayList();
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Railway> getAlters() {
        return this.f7713h;
    }

    public RailwayStationItem getArrivalstop() {
        return this.f7711f;
    }

    public RailwayStationItem getDeparturestop() {
        return this.f7710e;
    }

    public float getDistance() {
        return this.f7708c;
    }

    public List<RailwaySpace> getSpaces() {
        return this.f7714i;
    }

    public String getTime() {
        return this.f7706a;
    }

    public String getTrip() {
        return this.f7707b;
    }

    public String getType() {
        return this.f7709d;
    }

    public List<RailwayStationItem> getViastops() {
        return this.f7712g;
    }

    public void setAlters(List<Railway> list) {
        this.f7713h = list;
    }

    public void setArrivalstop(RailwayStationItem railwayStationItem) {
        this.f7711f = railwayStationItem;
    }

    public void setDeparturestop(RailwayStationItem railwayStationItem) {
        this.f7710e = railwayStationItem;
    }

    public void setDistance(float f) {
        this.f7708c = f;
    }

    public void setSpaces(List<RailwaySpace> list) {
        this.f7714i = list;
    }

    public void setTime(String str) {
        this.f7706a = str;
    }

    public void setTrip(String str) {
        this.f7707b = str;
    }

    public void setType(String str) {
        this.f7709d = str;
    }

    public void setViastops(List<RailwayStationItem> list) {
        this.f7712g = list;
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f7706a);
        parcel.writeString(this.f7707b);
        parcel.writeFloat(this.f7708c);
        parcel.writeString(this.f7709d);
        parcel.writeParcelable(this.f7710e, i);
        parcel.writeParcelable(this.f7711f, i);
        parcel.writeTypedList(this.f7712g);
        parcel.writeTypedList(this.f7713h);
        parcel.writeTypedList(this.f7714i);
    }

    protected RouteRailwayItem(Parcel parcel) {
        super(parcel);
        this.f7712g = new ArrayList();
        this.f7713h = new ArrayList();
        this.f7714i = new ArrayList();
        this.f7706a = parcel.readString();
        this.f7707b = parcel.readString();
        this.f7708c = parcel.readFloat();
        this.f7709d = parcel.readString();
        this.f7710e = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f7711f = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f7712g = parcel.createTypedArrayList(RailwayStationItem.CREATOR);
        this.f7713h = parcel.createTypedArrayList(Railway.CREATOR);
        this.f7714i = parcel.createTypedArrayList(RailwaySpace.CREATOR);
    }
}
