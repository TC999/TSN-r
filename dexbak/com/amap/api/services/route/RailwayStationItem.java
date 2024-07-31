package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = new Parcelable.Creator<RailwayStationItem>() { // from class: com.amap.api.services.route.RailwayStationItem.1
        /* renamed from: a */
        private static RailwayStationItem m51807a(Parcel parcel) {
            return new RailwayStationItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem createFromParcel(Parcel parcel) {
            return m51807a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem[] newArray(int i) {
            return m51808a(i);
        }

        /* renamed from: a */
        private static RailwayStationItem[] m51808a(int i) {
            return new RailwayStationItem[i];
        }
    };

    /* renamed from: a */
    private String f7674a;

    /* renamed from: b */
    private String f7675b;

    /* renamed from: c */
    private LatLonPoint f7676c;

    /* renamed from: d */
    private String f7677d;

    /* renamed from: e */
    private String f7678e;

    /* renamed from: f */
    private boolean f7679f;

    /* renamed from: g */
    private boolean f7680g;

    /* renamed from: h */
    private float f7681h;

    public RailwayStationItem() {
        this.f7679f = false;
        this.f7680g = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f7677d;
    }

    public String getID() {
        return this.f7674a;
    }

    public LatLonPoint getLocation() {
        return this.f7676c;
    }

    public String getName() {
        return this.f7675b;
    }

    public String getTime() {
        return this.f7678e;
    }

    public float getWait() {
        return this.f7681h;
    }

    public boolean isEnd() {
        return this.f7680g;
    }

    public boolean isStart() {
        return this.f7679f;
    }

    public void setAdcode(String str) {
        this.f7677d = str;
    }

    public void setID(String str) {
        this.f7674a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f7676c = latLonPoint;
    }

    public void setName(String str) {
        this.f7675b = str;
    }

    public void setTime(String str) {
        this.f7678e = str;
    }

    public void setWait(float f) {
        this.f7681h = f;
    }

    public void setisEnd(boolean z) {
        this.f7680g = z;
    }

    public void setisStart(boolean z) {
        this.f7679f = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7674a);
        parcel.writeString(this.f7675b);
        parcel.writeParcelable(this.f7676c, i);
        parcel.writeString(this.f7677d);
        parcel.writeString(this.f7678e);
        parcel.writeBooleanArray(new boolean[]{this.f7679f, this.f7680g});
        parcel.writeFloat(this.f7681h);
    }

    protected RailwayStationItem(Parcel parcel) {
        this.f7679f = false;
        this.f7680g = false;
        this.f7674a = parcel.readString();
        this.f7675b = parcel.readString();
        this.f7676c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7677d = parcel.readString();
        this.f7678e = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f7679f = zArr[0];
        this.f7680g = zArr[1];
        this.f7681h = parcel.readFloat();
    }
}
