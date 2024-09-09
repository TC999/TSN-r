package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new Parcelable.Creator<RouteBusLineItem>() { // from class: com.amap.api.services.route.RouteBusLineItem.1
        private static RouteBusLineItem a(Parcel parcel) {
            return new RouteBusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusLineItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusLineItem[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private BusStationItem f11390a;

    /* renamed from: b  reason: collision with root package name */
    private BusStationItem f11391b;

    /* renamed from: c  reason: collision with root package name */
    private List<LatLonPoint> f11392c;

    /* renamed from: d  reason: collision with root package name */
    private int f11393d;

    /* renamed from: e  reason: collision with root package name */
    private List<BusStationItem> f11394e;

    /* renamed from: f  reason: collision with root package name */
    private float f11395f;

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.f11392c = new ArrayList();
        this.f11394e = new ArrayList();
        this.f11390a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f11391b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f11392c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f11393d = parcel.readInt();
        this.f11394e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f11395f = parcel.readFloat();
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && getClass() == obj.getClass()) {
            RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
            BusStationItem busStationItem = this.f11391b;
            if (busStationItem == null) {
                if (routeBusLineItem.f11391b != null) {
                    return false;
                }
            } else if (!busStationItem.equals(routeBusLineItem.f11391b)) {
                return false;
            }
            BusStationItem busStationItem2 = this.f11390a;
            if (busStationItem2 == null) {
                if (routeBusLineItem.f11390a != null) {
                    return false;
                }
            } else if (!busStationItem2.equals(routeBusLineItem.f11390a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public BusStationItem getArrivalBusStation() {
        return this.f11391b;
    }

    public BusStationItem getDepartureBusStation() {
        return this.f11390a;
    }

    public float getDuration() {
        return this.f11395f;
    }

    public int getPassStationNum() {
        return this.f11393d;
    }

    public List<BusStationItem> getPassStations() {
        return this.f11394e;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11392c;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        BusStationItem busStationItem = this.f11391b;
        int hashCode2 = (hashCode + (busStationItem == null ? 0 : busStationItem.hashCode())) * 31;
        BusStationItem busStationItem2 = this.f11390a;
        return hashCode2 + (busStationItem2 != null ? busStationItem2.hashCode() : 0);
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.f11391b = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.f11390a = busStationItem;
    }

    public void setDuration(float f4) {
        this.f11395f = f4;
    }

    public void setPassStationNum(int i4) {
        this.f11393d = i4;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.f11394e = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11392c = list;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.f11390a, i4);
        parcel.writeParcelable(this.f11391b, i4);
        parcel.writeTypedList(this.f11392c);
        parcel.writeInt(this.f11393d);
        parcel.writeTypedList(this.f11394e);
        parcel.writeFloat(this.f11395f);
    }

    public RouteBusLineItem() {
        this.f11392c = new ArrayList();
        this.f11394e = new ArrayList();
    }
}
