package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RideStep implements Parcelable {
    public static final Parcelable.Creator<RideStep> CREATOR = new Parcelable.Creator<RideStep>() { // from class: com.amap.api.services.route.RideStep.1
        /* renamed from: a */
        private static RideStep m51800a(Parcel parcel) {
            return new RideStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideStep createFromParcel(Parcel parcel) {
            return m51800a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideStep[] newArray(int i) {
            return m51801a(i);
        }

        /* renamed from: a */
        private static RideStep[] m51801a(int i) {
            return new RideStep[i];
        }
    };

    /* renamed from: a */
    private String f7687a;

    /* renamed from: b */
    private String f7688b;

    /* renamed from: c */
    private String f7689c;

    /* renamed from: d */
    private float f7690d;

    /* renamed from: e */
    private float f7691e;

    /* renamed from: f */
    private List<LatLonPoint> f7692f;

    /* renamed from: g */
    private String f7693g;

    /* renamed from: h */
    private String f7694h;

    /* renamed from: i */
    private int f7695i;

    public RideStep() {
        this.f7692f = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f7693g;
    }

    public String getAssistantAction() {
        return this.f7694h;
    }

    public float getDistance() {
        return this.f7690d;
    }

    public float getDuration() {
        return this.f7691e;
    }

    public String getInstruction() {
        return this.f7687a;
    }

    public String getOrientation() {
        return this.f7688b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7692f;
    }

    public String getRoad() {
        return this.f7689c;
    }

    public int getRoadType() {
        return this.f7695i;
    }

    public void setAction(String str) {
        this.f7693g = str;
    }

    public void setAssistantAction(String str) {
        this.f7694h = str;
    }

    public void setDistance(float f) {
        this.f7690d = f;
    }

    public void setDuration(float f) {
        this.f7691e = f;
    }

    public void setInstruction(String str) {
        this.f7687a = str;
    }

    public void setOrientation(String str) {
        this.f7688b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7692f = list;
    }

    public void setRoad(String str) {
        this.f7689c = str;
    }

    public void setRoadType(int i) {
        this.f7695i = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7687a);
        parcel.writeString(this.f7688b);
        parcel.writeString(this.f7689c);
        parcel.writeFloat(this.f7690d);
        parcel.writeFloat(this.f7691e);
        parcel.writeTypedList(this.f7692f);
        parcel.writeString(this.f7693g);
        parcel.writeString(this.f7694h);
    }

    protected RideStep(Parcel parcel) {
        this.f7692f = new ArrayList();
        this.f7687a = parcel.readString();
        this.f7688b = parcel.readString();
        this.f7689c = parcel.readString();
        this.f7690d = parcel.readFloat();
        this.f7691e = parcel.readFloat();
        this.f7692f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7693g = parcel.readString();
        this.f7694h = parcel.readString();
    }
}
