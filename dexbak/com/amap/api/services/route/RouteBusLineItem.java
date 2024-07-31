package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Parcelable.Creator<RouteBusLineItem> CREATOR = new Parcelable.Creator<RouteBusLineItem>() { // from class: com.amap.api.services.route.RouteBusLineItem.1
        /* renamed from: a */
        private static RouteBusLineItem m51799a(Parcel parcel) {
            return new RouteBusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusLineItem createFromParcel(Parcel parcel) {
            return m51799a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusLineItem[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private BusStationItem f7696a;

    /* renamed from: b */
    private BusStationItem f7697b;

    /* renamed from: c */
    private List<LatLonPoint> f7698c;

    /* renamed from: d */
    private int f7699d;

    /* renamed from: e */
    private List<BusStationItem> f7700e;

    /* renamed from: f */
    private float f7701f;

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.f7698c = new ArrayList();
        this.f7700e = new ArrayList();
        this.f7696a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f7697b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f7698c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7699d = parcel.readInt();
        this.f7700e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f7701f = parcel.readFloat();
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
            BusStationItem busStationItem = this.f7697b;
            if (busStationItem == null) {
                if (routeBusLineItem.f7697b != null) {
                    return false;
                }
            } else if (!busStationItem.equals(routeBusLineItem.f7697b)) {
                return false;
            }
            BusStationItem busStationItem2 = this.f7696a;
            if (busStationItem2 == null) {
                if (routeBusLineItem.f7696a != null) {
                    return false;
                }
            } else if (!busStationItem2.equals(routeBusLineItem.f7696a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public BusStationItem getArrivalBusStation() {
        return this.f7697b;
    }

    public BusStationItem getDepartureBusStation() {
        return this.f7696a;
    }

    public float getDuration() {
        return this.f7701f;
    }

    public int getPassStationNum() {
        return this.f7699d;
    }

    public List<BusStationItem> getPassStations() {
        return this.f7700e;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7698c;
    }

    @Override // com.amap.api.services.busline.BusLineItem
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        BusStationItem busStationItem = this.f7697b;
        int hashCode2 = (hashCode + (busStationItem == null ? 0 : busStationItem.hashCode())) * 31;
        BusStationItem busStationItem2 = this.f7696a;
        return hashCode2 + (busStationItem2 != null ? busStationItem2.hashCode() : 0);
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.f7697b = busStationItem;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.f7696a = busStationItem;
    }

    public void setDuration(float f) {
        this.f7701f = f;
    }

    public void setPassStationNum(int i) {
        this.f7699d = i;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.f7700e = list;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7698c = list;
    }

    @Override // com.amap.api.services.busline.BusLineItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f7696a, i);
        parcel.writeParcelable(this.f7697b, i);
        parcel.writeTypedList(this.f7698c);
        parcel.writeInt(this.f7699d);
        parcel.writeTypedList(this.f7700e);
        parcel.writeFloat(this.f7701f);
    }

    public RouteBusLineItem() {
        this.f7698c = new ArrayList();
        this.f7700e = new ArrayList();
    }
}
