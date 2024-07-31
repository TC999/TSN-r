package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DriveStep implements Parcelable {
    public static final Parcelable.Creator<DriveStep> CREATOR = new Parcelable.Creator<DriveStep>() { // from class: com.amap.api.services.route.DriveStep.1
        /* renamed from: a */
        private static DriveStep m51815a(Parcel parcel) {
            return new DriveStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveStep createFromParcel(Parcel parcel) {
            return m51815a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveStep[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7638a;

    /* renamed from: b */
    private String f7639b;

    /* renamed from: c */
    private String f7640c;

    /* renamed from: d */
    private float f7641d;

    /* renamed from: e */
    private float f7642e;

    /* renamed from: f */
    private float f7643f;

    /* renamed from: g */
    private String f7644g;

    /* renamed from: h */
    private float f7645h;

    /* renamed from: i */
    private List<LatLonPoint> f7646i;

    /* renamed from: j */
    private String f7647j;

    /* renamed from: k */
    private String f7648k;

    /* renamed from: l */
    private List<RouteSearchCity> f7649l;

    /* renamed from: m */
    private List<TMC> f7650m;

    public DriveStep(Parcel parcel) {
        this.f7646i = new ArrayList();
        this.f7649l = new ArrayList();
        this.f7650m = new ArrayList();
        this.f7638a = parcel.readString();
        this.f7639b = parcel.readString();
        this.f7640c = parcel.readString();
        this.f7641d = parcel.readFloat();
        this.f7642e = parcel.readFloat();
        this.f7643f = parcel.readFloat();
        this.f7644g = parcel.readString();
        this.f7645h = parcel.readFloat();
        this.f7646i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7647j = parcel.readString();
        this.f7648k = parcel.readString();
        this.f7649l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f7650m = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f7647j;
    }

    public String getAssistantAction() {
        return this.f7648k;
    }

    public float getDistance() {
        return this.f7641d;
    }

    public float getDuration() {
        return this.f7645h;
    }

    public String getInstruction() {
        return this.f7638a;
    }

    public String getOrientation() {
        return this.f7639b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7646i;
    }

    public String getRoad() {
        return this.f7640c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f7649l;
    }

    public List<TMC> getTMCs() {
        return this.f7650m;
    }

    public float getTollDistance() {
        return this.f7643f;
    }

    public String getTollRoad() {
        return this.f7644g;
    }

    public float getTolls() {
        return this.f7642e;
    }

    public void setAction(String str) {
        this.f7647j = str;
    }

    public void setAssistantAction(String str) {
        this.f7648k = str;
    }

    public void setDistance(float f) {
        this.f7641d = f;
    }

    public void setDuration(float f) {
        this.f7645h = f;
    }

    public void setInstruction(String str) {
        this.f7638a = str;
    }

    public void setOrientation(String str) {
        this.f7639b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7646i = list;
    }

    public void setRoad(String str) {
        this.f7640c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f7649l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f7650m = list;
    }

    public void setTollDistance(float f) {
        this.f7643f = f;
    }

    public void setTollRoad(String str) {
        this.f7644g = str;
    }

    public void setTolls(float f) {
        this.f7642e = f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7638a);
        parcel.writeString(this.f7639b);
        parcel.writeString(this.f7640c);
        parcel.writeFloat(this.f7641d);
        parcel.writeFloat(this.f7642e);
        parcel.writeFloat(this.f7643f);
        parcel.writeString(this.f7644g);
        parcel.writeFloat(this.f7645h);
        parcel.writeTypedList(this.f7646i);
        parcel.writeString(this.f7647j);
        parcel.writeString(this.f7648k);
        parcel.writeTypedList(this.f7649l);
        parcel.writeTypedList(this.f7650m);
    }

    public DriveStep() {
        this.f7646i = new ArrayList();
        this.f7649l = new ArrayList();
        this.f7650m = new ArrayList();
    }
}
