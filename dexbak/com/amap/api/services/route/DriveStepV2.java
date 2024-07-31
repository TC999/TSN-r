package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DriveStepV2 implements Parcelable {
    public static final Parcelable.Creator<DriveStepV2> CREATOR = new Parcelable.Creator<DriveStepV2>() { // from class: com.amap.api.services.route.DriveStepV2.1
        /* renamed from: a */
        private static DriveStepV2 m51814a(Parcel parcel) {
            return new DriveStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveStepV2 createFromParcel(Parcel parcel) {
            return m51814a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveStepV2[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7651a;

    /* renamed from: b */
    private String f7652b;

    /* renamed from: c */
    private String f7653c;

    /* renamed from: d */
    private List<LatLonPoint> f7654d;

    /* renamed from: e */
    private List<RouteSearchCity> f7655e;

    /* renamed from: f */
    private List<TMC> f7656f;

    /* renamed from: g */
    private int f7657g;

    /* renamed from: h */
    private Cost f7658h;

    /* renamed from: i */
    private Navi f7659i;

    public DriveStepV2(Parcel parcel) {
        this.f7654d = new ArrayList();
        this.f7655e = new ArrayList();
        this.f7656f = new ArrayList();
        this.f7657g = -1;
        this.f7651a = parcel.readString();
        this.f7652b = parcel.readString();
        this.f7653c = parcel.readString();
        this.f7654d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7655e = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f7656f = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Cost getCostDetail() {
        return this.f7658h;
    }

    public String getInstruction() {
        return this.f7651a;
    }

    public Navi getNavi() {
        return this.f7659i;
    }

    public String getOrientation() {
        return this.f7652b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7654d;
    }

    public String getRoad() {
        return this.f7653c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f7655e;
    }

    public int getStepDistance() {
        return this.f7657g;
    }

    public List<TMC> getTMCs() {
        return this.f7656f;
    }

    public void setCostDetail(Cost cost) {
        this.f7658h = cost;
    }

    public void setInstruction(String str) {
        this.f7651a = str;
    }

    public void setNavi(Navi navi) {
        this.f7659i = navi;
    }

    public void setOrientation(String str) {
        this.f7652b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7654d = list;
    }

    public void setRoad(String str) {
        this.f7653c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f7655e = list;
    }

    public void setStepDistance(int i) {
        this.f7657g = i;
    }

    public void setTMCs(List<TMC> list) {
        this.f7656f = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7651a);
        parcel.writeString(this.f7652b);
        parcel.writeString(this.f7653c);
        parcel.writeTypedList(this.f7654d);
        parcel.writeTypedList(this.f7655e);
        parcel.writeTypedList(this.f7656f);
    }

    public DriveStepV2() {
        this.f7654d = new ArrayList();
        this.f7655e = new ArrayList();
        this.f7656f = new ArrayList();
        this.f7657g = -1;
    }
}
