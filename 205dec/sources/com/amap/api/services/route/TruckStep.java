package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TruckStep implements Parcelable {
    public static final Parcelable.Creator<TruckStep> CREATOR = new Parcelable.Creator<TruckStep>() { // from class: com.amap.api.services.route.TruckStep.1
        private static TruckStep a(Parcel parcel) {
            return new TruckStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckStep[] newArray(int i4) {
            return a(i4);
        }

        private static TruckStep[] a(int i4) {
            return new TruckStep[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11569a;

    /* renamed from: b  reason: collision with root package name */
    private String f11570b;

    /* renamed from: c  reason: collision with root package name */
    private String f11571c;

    /* renamed from: d  reason: collision with root package name */
    private float f11572d;

    /* renamed from: e  reason: collision with root package name */
    private float f11573e;

    /* renamed from: f  reason: collision with root package name */
    private float f11574f;

    /* renamed from: g  reason: collision with root package name */
    private String f11575g;

    /* renamed from: h  reason: collision with root package name */
    private float f11576h;

    /* renamed from: i  reason: collision with root package name */
    private List<LatLonPoint> f11577i;

    /* renamed from: j  reason: collision with root package name */
    private String f11578j;

    /* renamed from: k  reason: collision with root package name */
    private String f11579k;

    /* renamed from: l  reason: collision with root package name */
    private List<RouteSearchCity> f11580l;

    /* renamed from: m  reason: collision with root package name */
    private List<TMC> f11581m;

    public TruckStep() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f11578j;
    }

    public String getAssistantAction() {
        return this.f11579k;
    }

    public float getDistance() {
        return this.f11573e;
    }

    public float getDuration() {
        return this.f11576h;
    }

    public String getInstruction() {
        return this.f11569a;
    }

    public String getOrientation() {
        return this.f11570b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f11577i;
    }

    public String getRoad() {
        return this.f11571c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f11580l;
    }

    public List<TMC> getTMCs() {
        return this.f11581m;
    }

    public float getTollDistance() {
        return this.f11574f;
    }

    public String getTollRoad() {
        return this.f11575g;
    }

    public float getTolls() {
        return this.f11572d;
    }

    public void setAction(String str) {
        this.f11578j = str;
    }

    public void setAssistantAction(String str) {
        this.f11579k = str;
    }

    public void setDistance(float f4) {
        this.f11573e = f4;
    }

    public void setDuration(float f4) {
        this.f11576h = f4;
    }

    public void setInstruction(String str) {
        this.f11569a = str;
    }

    public void setOrientation(String str) {
        this.f11570b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f11577i = list;
    }

    public void setRoad(String str) {
        this.f11571c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f11580l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f11581m = list;
    }

    public void setTollDistance(float f4) {
        this.f11574f = f4;
    }

    public void setTollRoad(String str) {
        this.f11575g = str;
    }

    public void setTolls(float f4) {
        this.f11572d = f4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11569a);
        parcel.writeString(this.f11570b);
        parcel.writeString(this.f11571c);
        parcel.writeFloat(this.f11572d);
        parcel.writeFloat(this.f11573e);
        parcel.writeFloat(this.f11574f);
        parcel.writeString(this.f11575g);
        parcel.writeFloat(this.f11576h);
        parcel.writeTypedList(this.f11577i);
        parcel.writeString(this.f11578j);
        parcel.writeString(this.f11579k);
        parcel.writeTypedList(this.f11580l);
        parcel.writeTypedList(this.f11581m);
    }

    protected TruckStep(Parcel parcel) {
        this.f11569a = parcel.readString();
        this.f11570b = parcel.readString();
        this.f11571c = parcel.readString();
        this.f11572d = parcel.readFloat();
        this.f11573e = parcel.readFloat();
        this.f11574f = parcel.readFloat();
        this.f11575g = parcel.readString();
        this.f11576h = parcel.readFloat();
        this.f11577i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f11578j = parcel.readString();
        this.f11579k = parcel.readString();
        this.f11580l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f11581m = parcel.createTypedArrayList(TMC.CREATOR);
    }
}
