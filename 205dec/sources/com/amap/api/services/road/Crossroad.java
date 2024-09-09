package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class Crossroad extends Road implements Parcelable {
    public static final Parcelable.Creator<Crossroad> CREATOR = new Parcelable.Creator<Crossroad>() { // from class: com.amap.api.services.road.Crossroad.1
        private static Crossroad a(Parcel parcel) {
            return new Crossroad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Crossroad createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Crossroad[] newArray(int i4) {
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f11227a;

    /* renamed from: b  reason: collision with root package name */
    private String f11228b;

    /* renamed from: c  reason: collision with root package name */
    private String f11229c;

    /* renamed from: d  reason: collision with root package name */
    private String f11230d;

    /* renamed from: e  reason: collision with root package name */
    private String f11231e;

    /* renamed from: f  reason: collision with root package name */
    private String f11232f;

    /* synthetic */ Crossroad(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.f11228b;
    }

    public final float getDistance() {
        return this.f11227a;
    }

    public final String getFirstRoadId() {
        return this.f11229c;
    }

    public final String getFirstRoadName() {
        return this.f11230d;
    }

    public final String getSecondRoadId() {
        return this.f11231e;
    }

    public final String getSecondRoadName() {
        return this.f11232f;
    }

    public final void setDirection(String str) {
        this.f11228b = str;
    }

    public final void setDistance(float f4) {
        this.f11227a = f4;
    }

    public final void setFirstRoadId(String str) {
        this.f11229c = str;
    }

    public final void setFirstRoadName(String str) {
        this.f11230d = str;
    }

    public final void setSecondRoadId(String str) {
        this.f11231e = str;
    }

    public final void setSecondRoadName(String str) {
        this.f11232f = str;
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeFloat(this.f11227a);
        parcel.writeString(this.f11228b);
        parcel.writeString(this.f11229c);
        parcel.writeString(this.f11230d);
        parcel.writeString(this.f11231e);
        parcel.writeString(this.f11232f);
    }

    public Crossroad() {
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.f11227a = parcel.readFloat();
        this.f11228b = parcel.readString();
        this.f11229c = parcel.readString();
        this.f11230d = parcel.readString();
        this.f11231e = parcel.readString();
        this.f11232f = parcel.readString();
    }
}
