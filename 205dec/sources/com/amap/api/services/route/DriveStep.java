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
public class DriveStep implements Parcelable {
    public static final Parcelable.Creator<DriveStep> CREATOR = new Parcelable.Creator<DriveStep>() { // from class: com.amap.api.services.route.DriveStep.1
        private static DriveStep a(Parcel parcel) {
            return new DriveStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveStep[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11332a;

    /* renamed from: b  reason: collision with root package name */
    private String f11333b;

    /* renamed from: c  reason: collision with root package name */
    private String f11334c;

    /* renamed from: d  reason: collision with root package name */
    private float f11335d;

    /* renamed from: e  reason: collision with root package name */
    private float f11336e;

    /* renamed from: f  reason: collision with root package name */
    private float f11337f;

    /* renamed from: g  reason: collision with root package name */
    private String f11338g;

    /* renamed from: h  reason: collision with root package name */
    private float f11339h;

    /* renamed from: i  reason: collision with root package name */
    private List<LatLonPoint> f11340i;

    /* renamed from: j  reason: collision with root package name */
    private String f11341j;

    /* renamed from: k  reason: collision with root package name */
    private String f11342k;

    /* renamed from: l  reason: collision with root package name */
    private List<RouteSearchCity> f11343l;

    /* renamed from: m  reason: collision with root package name */
    private List<TMC> f11344m;

    public DriveStep(Parcel parcel) {
        this.f11340i = new ArrayList();
        this.f11343l = new ArrayList();
        this.f11344m = new ArrayList();
        this.f11332a = parcel.readString();
        this.f11333b = parcel.readString();
        this.f11334c = parcel.readString();
        this.f11335d = parcel.readFloat();
        this.f11336e = parcel.readFloat();
        this.f11337f = parcel.readFloat();
        this.f11338g = parcel.readString();
        this.f11339h = parcel.readFloat();
        this.f11340i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f11341j = parcel.readString();
        this.f11342k = parcel.readString();
        this.f11343l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f11344m = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f11341j;
    }

    public String getAssistantAction() {
        return this.f11342k;
    }

    public float getDistance() {
        return this.f11335d;
    }

    public float getDuration() {
        return this.f11339h;
    }

    public String getInstruction() {
        return this.f11332a;
    }

    public String getOrientation() {
        return this.f11333b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11340i;
    }

    public String getRoad() {
        return this.f11334c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f11343l;
    }

    public List<TMC> getTMCs() {
        return this.f11344m;
    }

    public float getTollDistance() {
        return this.f11337f;
    }

    public String getTollRoad() {
        return this.f11338g;
    }

    public float getTolls() {
        return this.f11336e;
    }

    public void setAction(String str) {
        this.f11341j = str;
    }

    public void setAssistantAction(String str) {
        this.f11342k = str;
    }

    public void setDistance(float f4) {
        this.f11335d = f4;
    }

    public void setDuration(float f4) {
        this.f11339h = f4;
    }

    public void setInstruction(String str) {
        this.f11332a = str;
    }

    public void setOrientation(String str) {
        this.f11333b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11340i = list;
    }

    public void setRoad(String str) {
        this.f11334c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f11343l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f11344m = list;
    }

    public void setTollDistance(float f4) {
        this.f11337f = f4;
    }

    public void setTollRoad(String str) {
        this.f11338g = str;
    }

    public void setTolls(float f4) {
        this.f11336e = f4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11332a);
        parcel.writeString(this.f11333b);
        parcel.writeString(this.f11334c);
        parcel.writeFloat(this.f11335d);
        parcel.writeFloat(this.f11336e);
        parcel.writeFloat(this.f11337f);
        parcel.writeString(this.f11338g);
        parcel.writeFloat(this.f11339h);
        parcel.writeTypedList(this.f11340i);
        parcel.writeString(this.f11341j);
        parcel.writeString(this.f11342k);
        parcel.writeTypedList(this.f11343l);
        parcel.writeTypedList(this.f11344m);
    }

    public DriveStep() {
        this.f11340i = new ArrayList();
        this.f11343l = new ArrayList();
        this.f11344m = new ArrayList();
    }
}
