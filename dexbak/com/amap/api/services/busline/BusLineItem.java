package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p047s.C2082j4;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BusLineItem implements Parcelable {
    public static final Parcelable.Creator<BusLineItem> CREATOR = new Parcelable.Creator<BusLineItem>() { // from class: com.amap.api.services.busline.BusLineItem.1
        /* renamed from: a */
        private static BusLineItem m51913a(Parcel parcel) {
            return new BusLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusLineItem createFromParcel(Parcel parcel) {
            return m51913a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusLineItem[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private float f7185a;

    /* renamed from: b */
    private String f7186b;

    /* renamed from: c */
    private String f7187c;

    /* renamed from: d */
    private String f7188d;

    /* renamed from: e */
    private List<LatLonPoint> f7189e;

    /* renamed from: f */
    private List<LatLonPoint> f7190f;

    /* renamed from: g */
    private String f7191g;

    /* renamed from: h */
    private String f7192h;

    /* renamed from: i */
    private String f7193i;

    /* renamed from: j */
    private Date f7194j;

    /* renamed from: k */
    private Date f7195k;

    /* renamed from: l */
    private String f7196l;

    /* renamed from: m */
    private float f7197m;

    /* renamed from: n */
    private float f7198n;

    /* renamed from: o */
    private List<BusStationItem> f7199o;

    public BusLineItem() {
        this.f7189e = new ArrayList();
        this.f7190f = new ArrayList();
        this.f7199o = new ArrayList();
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
            String str = this.f7191g;
            if (str == null) {
                if (busLineItem.f7191g != null) {
                    return false;
                }
            } else if (!str.equals(busLineItem.f7191g)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public float getBasicPrice() {
        return this.f7197m;
    }

    public List<LatLonPoint> getBounds() {
        return this.f7190f;
    }

    public String getBusCompany() {
        return this.f7196l;
    }

    public String getBusLineId() {
        return this.f7191g;
    }

    public String getBusLineName() {
        return this.f7186b;
    }

    public String getBusLineType() {
        return this.f7187c;
    }

    public List<BusStationItem> getBusStations() {
        return this.f7199o;
    }

    public String getCityCode() {
        return this.f7188d;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.f7189e;
    }

    public float getDistance() {
        return this.f7185a;
    }

    public Date getFirstBusTime() {
        Date date = this.f7194j;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public Date getLastBusTime() {
        Date date = this.f7195k;
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    public String getOriginatingStation() {
        return this.f7192h;
    }

    public String getTerminalStation() {
        return this.f7193i;
    }

    public float getTotalPrice() {
        return this.f7198n;
    }

    public int hashCode() {
        String str = this.f7191g;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setBasicPrice(float f) {
        this.f7197m = f;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f7190f = list;
    }

    public void setBusCompany(String str) {
        this.f7196l = str;
    }

    public void setBusLineId(String str) {
        this.f7191g = str;
    }

    public void setBusLineName(String str) {
        this.f7186b = str;
    }

    public void setBusLineType(String str) {
        this.f7187c = str;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.f7199o = list;
    }

    public void setCityCode(String str) {
        this.f7188d = str;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.f7189e = list;
    }

    public void setDistance(float f) {
        this.f7185a = f;
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.f7194j = null;
        } else {
            this.f7194j = (Date) date.clone();
        }
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.f7195k = null;
        } else {
            this.f7195k = (Date) date.clone();
        }
    }

    public void setOriginatingStation(String str) {
        this.f7192h = str;
    }

    public void setTerminalStation(String str) {
        this.f7193i = str;
    }

    public void setTotalPrice(float f) {
        this.f7198n = f;
    }

    public String toString() {
        return this.f7186b + " " + C2082j4.m52829e(this.f7194j) + "-" + C2082j4.m52829e(this.f7195k);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f7185a);
        parcel.writeString(this.f7186b);
        parcel.writeString(this.f7187c);
        parcel.writeString(this.f7188d);
        parcel.writeList(this.f7189e);
        parcel.writeList(this.f7190f);
        parcel.writeString(this.f7191g);
        parcel.writeString(this.f7192h);
        parcel.writeString(this.f7193i);
        parcel.writeString(C2082j4.m52829e(this.f7194j));
        parcel.writeString(C2082j4.m52829e(this.f7195k));
        parcel.writeString(this.f7196l);
        parcel.writeFloat(this.f7197m);
        parcel.writeFloat(this.f7198n);
        parcel.writeList(this.f7199o);
    }

    public BusLineItem(Parcel parcel) {
        this.f7189e = new ArrayList();
        this.f7190f = new ArrayList();
        this.f7199o = new ArrayList();
        this.f7185a = parcel.readFloat();
        this.f7186b = parcel.readString();
        this.f7187c = parcel.readString();
        this.f7188d = parcel.readString();
        this.f7189e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f7190f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f7191g = parcel.readString();
        this.f7192h = parcel.readString();
        this.f7193i = parcel.readString();
        this.f7194j = C2082j4.m52819o(parcel.readString());
        this.f7195k = C2082j4.m52819o(parcel.readString());
        this.f7196l = parcel.readString();
        this.f7197m = parcel.readFloat();
        this.f7198n = parcel.readFloat();
        this.f7199o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
