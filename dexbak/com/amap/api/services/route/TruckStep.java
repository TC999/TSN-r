package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TruckStep implements Parcelable {
    public static final Parcelable.Creator<TruckStep> CREATOR = new Parcelable.Creator<TruckStep>() { // from class: com.amap.api.services.route.TruckStep.1
        /* renamed from: a */
        private static TruckStep m51753a(Parcel parcel) {
            return new TruckStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckStep createFromParcel(Parcel parcel) {
            return m51753a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckStep[] newArray(int i) {
            return m51754a(i);
        }

        /* renamed from: a */
        private static TruckStep[] m51754a(int i) {
            return new TruckStep[i];
        }
    };

    /* renamed from: a */
    private String f7875a;

    /* renamed from: b */
    private String f7876b;

    /* renamed from: c */
    private String f7877c;

    /* renamed from: d */
    private float f7878d;

    /* renamed from: e */
    private float f7879e;

    /* renamed from: f */
    private float f7880f;

    /* renamed from: g */
    private String f7881g;

    /* renamed from: h */
    private float f7882h;

    /* renamed from: i */
    private List<LatLonPoint> f7883i;

    /* renamed from: j */
    private String f7884j;

    /* renamed from: k */
    private String f7885k;

    /* renamed from: l */
    private List<RouteSearchCity> f7886l;

    /* renamed from: m */
    private List<TMC> f7887m;

    public TruckStep() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f7884j;
    }

    public String getAssistantAction() {
        return this.f7885k;
    }

    public float getDistance() {
        return this.f7879e;
    }

    public float getDuration() {
        return this.f7882h;
    }

    public String getInstruction() {
        return this.f7875a;
    }

    public String getOrientation() {
        return this.f7876b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7883i;
    }

    public String getRoad() {
        return this.f7877c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f7886l;
    }

    public List<TMC> getTMCs() {
        return this.f7887m;
    }

    public float getTollDistance() {
        return this.f7880f;
    }

    public String getTollRoad() {
        return this.f7881g;
    }

    public float getTolls() {
        return this.f7878d;
    }

    public void setAction(String str) {
        this.f7884j = str;
    }

    public void setAssistantAction(String str) {
        this.f7885k = str;
    }

    public void setDistance(float f) {
        this.f7879e = f;
    }

    public void setDuration(float f) {
        this.f7882h = f;
    }

    public void setInstruction(String str) {
        this.f7875a = str;
    }

    public void setOrientation(String str) {
        this.f7876b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7883i = list;
    }

    public void setRoad(String str) {
        this.f7877c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f7886l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f7887m = list;
    }

    public void setTollDistance(float f) {
        this.f7880f = f;
    }

    public void setTollRoad(String str) {
        this.f7881g = str;
    }

    public void setTolls(float f) {
        this.f7878d = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7875a);
        parcel.writeString(this.f7876b);
        parcel.writeString(this.f7877c);
        parcel.writeFloat(this.f7878d);
        parcel.writeFloat(this.f7879e);
        parcel.writeFloat(this.f7880f);
        parcel.writeString(this.f7881g);
        parcel.writeFloat(this.f7882h);
        parcel.writeTypedList(this.f7883i);
        parcel.writeString(this.f7884j);
        parcel.writeString(this.f7885k);
        parcel.writeTypedList(this.f7886l);
        parcel.writeTypedList(this.f7887m);
    }

    protected TruckStep(Parcel parcel) {
        this.f7875a = parcel.readString();
        this.f7876b = parcel.readString();
        this.f7877c = parcel.readString();
        this.f7878d = parcel.readFloat();
        this.f7879e = parcel.readFloat();
        this.f7880f = parcel.readFloat();
        this.f7881g = parcel.readString();
        this.f7882h = parcel.readFloat();
        this.f7883i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7884j = parcel.readString();
        this.f7885k = parcel.readString();
        this.f7886l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f7887m = parcel.createTypedArrayList(TMC.CREATOR);
    }
}
