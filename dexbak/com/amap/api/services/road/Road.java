package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new Parcelable.Creator<Road>() { // from class: com.amap.api.services.road.Road.1
        /* renamed from: a */
        private static Road m51842a(Parcel parcel) {
            return new Road(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Road createFromParcel(Parcel parcel) {
            return m51842a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Road[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7539a;

    /* renamed from: b */
    private String f7540b;

    /* renamed from: c */
    private String f7541c;

    /* renamed from: d */
    private float f7542d;

    /* renamed from: e */
    private String f7543e;

    /* renamed from: f */
    private LatLonPoint f7544f;

    public Road() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f7544f;
    }

    public String getCityCode() {
        return this.f7541c;
    }

    public String getId() {
        return this.f7539a;
    }

    public String getName() {
        return this.f7540b;
    }

    public float getRoadWidth() {
        return this.f7542d;
    }

    public String getType() {
        return this.f7543e;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f7544f = latLonPoint;
    }

    public void setCityCode(String str) {
        this.f7541c = str;
    }

    public void setId(String str) {
        this.f7539a = str;
    }

    public void setName(String str) {
        this.f7540b = str;
    }

    public void setRoadWidth(float f) {
        this.f7542d = f;
    }

    public void setType(String str) {
        this.f7543e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7539a);
        parcel.writeString(this.f7540b);
        parcel.writeString(this.f7541c);
        parcel.writeFloat(this.f7542d);
        parcel.writeString(this.f7543e);
        parcel.writeValue(this.f7544f);
    }

    public Road(String str, String str2) {
        this.f7539a = str;
        this.f7540b = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Road(Parcel parcel) {
        this.f7539a = parcel.readString();
        this.f7540b = parcel.readString();
        this.f7541c = parcel.readString();
        this.f7542d = parcel.readFloat();
        this.f7543e = parcel.readString();
        this.f7544f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
