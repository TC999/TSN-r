package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new Parcelable.Creator<RegeocodeRoad>() { // from class: com.amap.api.services.geocoder.RegeocodeRoad.1
        private static RegeocodeRoad a(Parcel parcel) {
            return new RegeocodeRoad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeRoad createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeRoad[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11090a;

    /* renamed from: b  reason: collision with root package name */
    private String f11091b;

    /* renamed from: c  reason: collision with root package name */
    private float f11092c;

    /* renamed from: d  reason: collision with root package name */
    private String f11093d;

    /* renamed from: e  reason: collision with root package name */
    private LatLonPoint f11094e;

    /* synthetic */ RegeocodeRoad(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.f11093d;
    }

    public final float getDistance() {
        return this.f11092c;
    }

    public final String getId() {
        return this.f11090a;
    }

    public final LatLonPoint getLatLngPoint() {
        return this.f11094e;
    }

    public final String getName() {
        return this.f11091b;
    }

    public final void setDirection(String str) {
        this.f11093d = str;
    }

    public final void setDistance(float f4) {
        this.f11092c = f4;
    }

    public final void setId(String str) {
        this.f11090a = str;
    }

    public final void setLatLngPoint(LatLonPoint latLonPoint) {
        this.f11094e = latLonPoint;
    }

    public final void setName(String str) {
        this.f11091b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11090a);
        parcel.writeString(this.f11091b);
        parcel.writeFloat(this.f11092c);
        parcel.writeString(this.f11093d);
        parcel.writeValue(this.f11094e);
    }

    public RegeocodeRoad() {
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f11090a = parcel.readString();
        this.f11091b = parcel.readString();
        this.f11092c = parcel.readFloat();
        this.f11093d = parcel.readString();
        this.f11094e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
