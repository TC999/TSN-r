package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusStationItem implements Parcelable {
    public static final Parcelable.Creator<BusStationItem> CREATOR = new Parcelable.Creator<BusStationItem>() { // from class: com.amap.api.services.busline.BusStationItem.1
        private static BusStationItem a(Parcel parcel) {
            return new BusStationItem(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStationItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStationItem[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10909a;

    /* renamed from: b  reason: collision with root package name */
    private String f10910b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f10911c;

    /* renamed from: d  reason: collision with root package name */
    private String f10912d;

    /* renamed from: e  reason: collision with root package name */
    private String f10913e;

    /* renamed from: f  reason: collision with root package name */
    private List<BusLineItem> f10914f;

    /* synthetic */ BusStationItem(Parcel parcel, byte b4) {
        this(parcel);
    }

    private static String a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                stringBuffer.append(list.get(i4).getBusLineName());
                if (i4 < list.size() - 1) {
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
            String str = this.f10909a;
            if (str == null) {
                if (busStationItem.f10909a != null) {
                    return false;
                }
            } else if (!str.equals(busStationItem.f10909a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getAdCode() {
        return this.f10913e;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f10914f;
    }

    public String getBusStationId() {
        return this.f10909a;
    }

    public String getBusStationName() {
        return this.f10910b;
    }

    public String getCityCode() {
        return this.f10912d;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f10911c;
    }

    public int hashCode() {
        String str = this.f10909a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setAdCode(String str) {
        this.f10913e = str;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f10914f = list;
    }

    public void setBusStationId(String str) {
        this.f10909a = str;
    }

    public void setBusStationName(String str) {
        this.f10910b = str;
    }

    public void setCityCode(String str) {
        this.f10912d = str;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f10911c = latLonPoint;
    }

    public String toString() {
        return "BusStationName: " + this.f10910b + " LatLonPoint: " + this.f10911c.toString() + " BusLines: " + a(this.f10914f) + " CityCode: " + this.f10912d + " AdCode: " + this.f10913e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10910b);
        parcel.writeString(this.f10909a);
        parcel.writeValue(this.f10911c);
        parcel.writeString(this.f10912d);
        parcel.writeString(this.f10913e);
        parcel.writeList(this.f10914f);
    }

    public BusStationItem() {
        this.f10914f = new ArrayList();
    }

    private BusStationItem(Parcel parcel) {
        this.f10914f = new ArrayList();
        this.f10910b = parcel.readString();
        this.f10909a = parcel.readString();
        this.f10911c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f10912d = parcel.readString();
        this.f10913e = parcel.readString();
        this.f10914f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
