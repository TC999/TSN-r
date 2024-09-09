package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.j4;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new Parcelable.Creator<BusLineItem>() { // from class: com.amap.api.services.busline.BusLineItem.1
        private static BusLineItem a(Parcel parcel) {
            return new BusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusLineItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusLineItem[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f10881a;

    /* renamed from: b  reason: collision with root package name */
    private String f10882b;

    /* renamed from: c  reason: collision with root package name */
    private String f10883c;

    /* renamed from: d  reason: collision with root package name */
    private String f10884d;

    /* renamed from: e  reason: collision with root package name */
    private List<LatLonPoint> f10885e;

    /* renamed from: f  reason: collision with root package name */
    private List<LatLonPoint> f10886f;

    /* renamed from: g  reason: collision with root package name */
    private String f10887g;

    /* renamed from: h  reason: collision with root package name */
    private String f10888h;

    /* renamed from: i  reason: collision with root package name */
    private String f10889i;

    /* renamed from: j  reason: collision with root package name */
    private Date f10890j;

    /* renamed from: k  reason: collision with root package name */
    private Date f10891k;

    /* renamed from: l  reason: collision with root package name */
    private String f10892l;

    /* renamed from: m  reason: collision with root package name */
    private float f10893m;

    /* renamed from: n  reason: collision with root package name */
    private float f10894n;

    /* renamed from: o  reason: collision with root package name */
    private List<BusStationItem> f10895o;

    public BusLineItem() {
        this.f10885e = new ArrayList();
        this.f10886f = new ArrayList();
        this.f10895o = new ArrayList();
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
            BusLineItem busLineItem = (BusLineItem) obj;
            String str = this.f10887g;
            if (str == null) {
                if (busLineItem.f10887g != null) {
                    return false;
                }
            } else if (!str.equals(busLineItem.f10887g)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public float getBasicPrice() {
        return this.f10893m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f10886f;
    }

    public String getBusCompany() {
        return this.f10892l;
    }

    public String getBusLineId() {
        return this.f10887g;
    }

    public String getBusLineName() {
        return this.f10882b;
    }

    public String getBusLineType() {
        return this.f10883c;
    }

    public List<BusStationItem> getBusStations() {
        return this.f10895o;
    }

    public String getCityCode() {
        return this.f10884d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.f10885e;
    }

    public float getDistance() {
        return this.f10881a;
    }

    public Date getFirstBusTime() {
        Date date = this.f10890j;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public Date getLastBusTime() {
        Date date = this.f10891k;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getOriginatingStation() {
        return this.f10888h;
    }

    public String getTerminalStation() {
        return this.f10889i;
    }

    public float getTotalPrice() {
        return this.f10894n;
    }

    public int hashCode() {
        String str = this.f10887g;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setBasicPrice(float f4) {
        this.f10893m = f4;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f10886f = list;
    }

    public void setBusCompany(String str) {
        this.f10892l = str;
    }

    public void setBusLineId(String str) {
        this.f10887g = str;
    }

    public void setBusLineName(String str) {
        this.f10882b = str;
    }

    public void setBusLineType(String str) {
        this.f10883c = str;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.f10895o = list;
    }

    public void setCityCode(String str) {
        this.f10884d = str;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.f10885e = list;
    }

    public void setDistance(float f4) {
        this.f10881a = f4;
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.f10890j = null;
        } else {
            this.f10890j = (Date) date.clone();
        }
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.f10891k = null;
        } else {
            this.f10891k = (Date) date.clone();
        }
    }

    public void setOriginatingStation(String str) {
        this.f10888h = str;
    }

    public void setTerminalStation(String str) {
        this.f10889i = str;
    }

    public void setTotalPrice(float f4) {
        this.f10894n = f4;
    }

    public String toString() {
        return this.f10882b + " " + j4.e(this.f10890j) + "-" + j4.e(this.f10891k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeFloat(this.f10881a);
        parcel.writeString(this.f10882b);
        parcel.writeString(this.f10883c);
        parcel.writeString(this.f10884d);
        parcel.writeList(this.f10885e);
        parcel.writeList(this.f10886f);
        parcel.writeString(this.f10887g);
        parcel.writeString(this.f10888h);
        parcel.writeString(this.f10889i);
        parcel.writeString(j4.e(this.f10890j));
        parcel.writeString(j4.e(this.f10891k));
        parcel.writeString(this.f10892l);
        parcel.writeFloat(this.f10893m);
        parcel.writeFloat(this.f10894n);
        parcel.writeList(this.f10895o);
    }

    public BusLineItem(Parcel parcel) {
        this.f10885e = new ArrayList();
        this.f10886f = new ArrayList();
        this.f10895o = new ArrayList();
        this.f10881a = parcel.readFloat();
        this.f10882b = parcel.readString();
        this.f10883c = parcel.readString();
        this.f10884d = parcel.readString();
        this.f10885e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f10886f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f10887g = parcel.readString();
        this.f10888h = parcel.readString();
        this.f10889i = parcel.readString();
        this.f10890j = j4.o(parcel.readString());
        this.f10891k = j4.o(parcel.readString());
        this.f10892l = parcel.readString();
        this.f10893m = parcel.readFloat();
        this.f10894n = parcel.readFloat();
        this.f10895o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
