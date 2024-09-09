package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = new Parcelable.Creator<RailwayStationItem>() { // from class: com.amap.api.services.route.RailwayStationItem.1
        private static RailwayStationItem a(Parcel parcel) {
            return new RailwayStationItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem[] newArray(int i4) {
            return a(i4);
        }

        private static RailwayStationItem[] a(int i4) {
            return new RailwayStationItem[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11368a;

    /* renamed from: b  reason: collision with root package name */
    private String f11369b;

    /* renamed from: c  reason: collision with root package name */
    private LatLonPoint f11370c;

    /* renamed from: d  reason: collision with root package name */
    private String f11371d;

    /* renamed from: e  reason: collision with root package name */
    private String f11372e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11373f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11374g;

    /* renamed from: h  reason: collision with root package name */
    private float f11375h;

    public RailwayStationItem() {
        this.f11373f = false;
        this.f11374g = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.f11371d;
    }

    public String getID() {
        return this.f11368a;
    }

    public LatLonPoint getLocation() {
        return this.f11370c;
    }

    public String getName() {
        return this.f11369b;
    }

    public String getTime() {
        return this.f11372e;
    }

    public float getWait() {
        return this.f11375h;
    }

    public boolean isEnd() {
        return this.f11374g;
    }

    public boolean isStart() {
        return this.f11373f;
    }

    public void setAdcode(String str) {
        this.f11371d = str;
    }

    public void setID(String str) {
        this.f11368a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f11370c = latLonPoint;
    }

    public void setName(String str) {
        this.f11369b = str;
    }

    public void setTime(String str) {
        this.f11372e = str;
    }

    public void setWait(float f4) {
        this.f11375h = f4;
    }

    public void setisEnd(boolean z3) {
        this.f11374g = z3;
    }

    public void setisStart(boolean z3) {
        this.f11373f = z3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11368a);
        parcel.writeString(this.f11369b);
        parcel.writeParcelable(this.f11370c, i4);
        parcel.writeString(this.f11371d);
        parcel.writeString(this.f11372e);
        parcel.writeBooleanArray(new boolean[]{this.f11373f, this.f11374g});
        parcel.writeFloat(this.f11375h);
    }

    protected RailwayStationItem(Parcel parcel) {
        this.f11373f = false;
        this.f11374g = false;
        this.f11368a = parcel.readString();
        this.f11369b = parcel.readString();
        this.f11370c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f11371d = parcel.readString();
        this.f11372e = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f11373f = zArr[0];
        this.f11374g = zArr[1];
        this.f11375h = parcel.readFloat();
    }
}
