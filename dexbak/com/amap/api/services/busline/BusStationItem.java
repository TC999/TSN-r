package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new Parcelable.Creator<BusStationItem>() { // from class: com.amap.api.services.busline.BusStationItem.1
        /* renamed from: a */
        private static BusStationItem m51910a(Parcel parcel) {
            return new BusStationItem(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStationItem createFromParcel(Parcel parcel) {
            return m51910a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStationItem[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7213a;

    /* renamed from: b */
    private String f7214b;

    /* renamed from: c */
    private LatLonPoint f7215c;

    /* renamed from: d */
    private String f7216d;

    /* renamed from: e */
    private String f7217e;

    /* renamed from: f */
    private List<BusLineItem> f7218f;

    /* synthetic */ BusStationItem(Parcel parcel, byte b) {
        this(parcel);
    }

    /* renamed from: a */
    private static String m51911a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                stringBuffer.append(list.get(i).getBusLineName());
                if (i < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusStationItem busStationItem = (BusStationItem) obj;
            String str = this.f7213a;
            if (str == null) {
                if (busStationItem.f7213a != null) {
                    return false;
                }
            } else if (!str.equals(busStationItem.f7213a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getAdCode() {
        return this.f7217e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f7218f;
    }

    public String getBusStationId() {
        return this.f7213a;
    }

    public String getBusStationName() {
        return this.f7214b;
    }

    public String getCityCode() {
        return this.f7216d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f7215c;
    }

    public int hashCode() {
        String str = this.f7213a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f7217e = str;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f7218f = list;
    }

    public void setBusStationId(String str) {
        this.f7213a = str;
    }

    public void setBusStationName(String str) {
        this.f7214b = str;
    }

    public void setCityCode(String str) {
        this.f7216d = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f7215c = latLonPoint;
    }

    public String toString() {
        return "BusStationName: " + this.f7214b + " LatLonPoint: " + this.f7215c.toString() + " BusLines: " + m51911a(this.f7218f) + " CityCode: " + this.f7216d + " AdCode: " + this.f7217e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7214b);
        parcel.writeString(this.f7213a);
        parcel.writeValue(this.f7215c);
        parcel.writeString(this.f7216d);
        parcel.writeString(this.f7217e);
        parcel.writeList(this.f7218f);
    }

    public BusStationItem() {
        this.f7218f = new ArrayList();
    }

    private BusStationItem(Parcel parcel) {
        this.f7218f = new ArrayList();
        this.f7214b = parcel.readString();
        this.f7213a = parcel.readString();
        this.f7215c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f7216d = parcel.readString();
        this.f7217e = parcel.readString();
        this.f7218f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
