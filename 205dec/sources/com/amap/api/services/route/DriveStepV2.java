package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DriveStepV2 implements Parcelable {
    public static final Parcelable.Creator<DriveStepV2> CREATOR = new Parcelable.Creator<DriveStepV2>() { // from class: com.amap.api.services.route.DriveStepV2.1
        private static DriveStepV2 a(Parcel parcel) {
            return new DriveStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveStepV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveStepV2[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11345a;

    /* renamed from: b  reason: collision with root package name */
    private String f11346b;

    /* renamed from: c  reason: collision with root package name */
    private String f11347c;

    /* renamed from: d  reason: collision with root package name */
    private List<LatLonPoint> f11348d;

    /* renamed from: e  reason: collision with root package name */
    private List<RouteSearchCity> f11349e;

    /* renamed from: f  reason: collision with root package name */
    private List<TMC> f11350f;

    /* renamed from: g  reason: collision with root package name */
    private int f11351g;

    /* renamed from: h  reason: collision with root package name */
    private Cost f11352h;

    /* renamed from: i  reason: collision with root package name */
    private Navi f11353i;

    public DriveStepV2(Parcel parcel) {
        this.f11348d = new ArrayList();
        this.f11349e = new ArrayList();
        this.f11350f = new ArrayList();
        this.f11351g = -1;
        this.f11345a = parcel.readString();
        this.f11346b = parcel.readString();
        this.f11347c = parcel.readString();
        this.f11348d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f11349e = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f11350f = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Cost getCostDetail() {
        return this.f11352h;
    }

    public String getInstruction() {
        return this.f11345a;
    }

    public Navi getNavi() {
        return this.f11353i;
    }

    public String getOrientation() {
        return this.f11346b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11348d;
    }

    public String getRoad() {
        return this.f11347c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f11349e;
    }

    public int getStepDistance() {
        return this.f11351g;
    }

    public List<TMC> getTMCs() {
        return this.f11350f;
    }

    public void setCostDetail(Cost cost) {
        this.f11352h = cost;
    }

    public void setInstruction(String str) {
        this.f11345a = str;
    }

    public void setNavi(Navi navi) {
        this.f11353i = navi;
    }

    public void setOrientation(String str) {
        this.f11346b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11348d = list;
    }

    public void setRoad(String str) {
        this.f11347c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f11349e = list;
    }

    public void setStepDistance(int i4) {
        this.f11351g = i4;
    }

    public void setTMCs(List<TMC> list) {
        this.f11350f = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11345a);
        parcel.writeString(this.f11346b);
        parcel.writeString(this.f11347c);
        parcel.writeTypedList(this.f11348d);
        parcel.writeTypedList(this.f11349e);
        parcel.writeTypedList(this.f11350f);
    }

    public DriveStepV2() {
        this.f11348d = new ArrayList();
        this.f11349e = new ArrayList();
        this.f11350f = new ArrayList();
        this.f11351g = -1;
    }
}
