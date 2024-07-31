package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new Parcelable.Creator<RegeocodeRoad>() { // from class: com.amap.api.services.geocoder.RegeocodeRoad.1
        /* renamed from: a */
        private static RegeocodeRoad m51870a(Parcel parcel) {
            return new RegeocodeRoad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeRoad createFromParcel(Parcel parcel) {
            return m51870a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeRoad[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private String f7396a;

    /* renamed from: b */
    private String f7397b;

    /* renamed from: c */
    private float f7398c;

    /* renamed from: d */
    private String f7399d;

    /* renamed from: e */
    private LatLonPoint f7400e;

    /* synthetic */ RegeocodeRoad(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.f7399d;
    }

    public final float getDistance() {
        return this.f7398c;
    }

    public final String getId() {
        return this.f7396a;
    }

    public final LatLonPoint getLatLngPoint() {
        return this.f7400e;
    }

    public final String getName() {
        return this.f7397b;
    }

    public final void setDirection(String str) {
        this.f7399d = str;
    }

    public final void setDistance(float f) {
        this.f7398c = f;
    }

    public final void setId(String str) {
        this.f7396a = str;
    }

    public final void setLatLngPoint(LatLonPoint latLonPoint) {
        this.f7400e = latLonPoint;
    }

    public final void setName(String str) {
        this.f7397b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7396a);
        parcel.writeString(this.f7397b);
        parcel.writeFloat(this.f7398c);
        parcel.writeString(this.f7399d);
        parcel.writeValue(this.f7400e);
    }

    public RegeocodeRoad() {
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f7396a = parcel.readString();
        this.f7397b = parcel.readString();
        this.f7398c = parcel.readFloat();
        this.f7399d = parcel.readString();
        this.f7400e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
