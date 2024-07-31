package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new Parcelable.Creator<WalkStep>() { // from class: com.amap.api.services.route.WalkStep.1
        /* renamed from: a */
        private static WalkStep m51747a(Parcel parcel) {
            return new WalkStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkStep createFromParcel(Parcel parcel) {
            return m51747a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WalkStep[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7893a;

    /* renamed from: b */
    private String f7894b;

    /* renamed from: c */
    private String f7895c;

    /* renamed from: d */
    private float f7896d;

    /* renamed from: e */
    private float f7897e;

    /* renamed from: f */
    private List<LatLonPoint> f7898f;

    /* renamed from: g */
    private String f7899g;

    /* renamed from: h */
    private String f7900h;

    /* renamed from: i */
    private int f7901i;

    public WalkStep(Parcel parcel) {
        this.f7898f = new ArrayList();
        this.f7893a = parcel.readString();
        this.f7894b = parcel.readString();
        this.f7895c = parcel.readString();
        this.f7896d = parcel.readFloat();
        this.f7897e = parcel.readFloat();
        this.f7898f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7899g = parcel.readString();
        this.f7900h = parcel.readString();
        this.f7901i = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f7899g;
    }

    public String getAssistantAction() {
        return this.f7900h;
    }

    public float getDistance() {
        return this.f7896d;
    }

    public float getDuration() {
        return this.f7897e;
    }

    public String getInstruction() {
        return this.f7893a;
    }

    public String getOrientation() {
        return this.f7894b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f7898f;
    }

    public String getRoad() {
        return this.f7895c;
    }

    public int getRoadType() {
        return this.f7901i;
    }

    public void setAction(String str) {
        this.f7899g = str;
    }

    public void setAssistantAction(String str) {
        this.f7900h = str;
    }

    public void setDistance(float f) {
        this.f7896d = f;
    }

    public void setDuration(float f) {
        this.f7897e = f;
    }

    public void setInstruction(String str) {
        this.f7893a = str;
    }

    public void setOrientation(String str) {
        this.f7894b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f7898f = list;
    }

    public void setRoad(String str) {
        this.f7895c = str;
    }

    public void setRoadType(int i) {
        this.f7901i = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7893a);
        parcel.writeString(this.f7894b);
        parcel.writeString(this.f7895c);
        parcel.writeFloat(this.f7896d);
        parcel.writeFloat(this.f7897e);
        parcel.writeTypedList(this.f7898f);
        parcel.writeString(this.f7899g);
        parcel.writeString(this.f7900h);
        parcel.writeInt(this.f7901i);
    }

    public WalkStep() {
        this.f7898f = new ArrayList();
    }
}
