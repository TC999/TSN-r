package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Crossroad extends Road implements Parcelable {
    public static final Parcelable.Creator<Crossroad> CREATOR = new Parcelable.Creator<Crossroad>() { // from class: com.amap.api.services.road.Crossroad.1
        /* renamed from: a */
        private static Crossroad m51843a(Parcel parcel) {
            return new Crossroad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Crossroad createFromParcel(Parcel parcel) {
            return m51843a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Crossroad[] newArray(int i) {
            return null;
        }
    };

    /* renamed from: a */
    private float f7533a;

    /* renamed from: b */
    private String f7534b;

    /* renamed from: c */
    private String f7535c;

    /* renamed from: d */
    private String f7536d;

    /* renamed from: e */
    private String f7537e;

    /* renamed from: f */
    private String f7538f;

    /* synthetic */ Crossroad(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.f7534b;
    }

    public final float getDistance() {
        return this.f7533a;
    }

    public final String getFirstRoadId() {
        return this.f7535c;
    }

    public final String getFirstRoadName() {
        return this.f7536d;
    }

    public final String getSecondRoadId() {
        return this.f7537e;
    }

    public final String getSecondRoadName() {
        return this.f7538f;
    }

    public final void setDirection(String str) {
        this.f7534b = str;
    }

    public final void setDistance(float f) {
        this.f7533a = f;
    }

    public final void setFirstRoadId(String str) {
        this.f7535c = str;
    }

    public final void setFirstRoadName(String str) {
        this.f7536d = str;
    }

    public final void setSecondRoadId(String str) {
        this.f7537e = str;
    }

    public final void setSecondRoadName(String str) {
        this.f7538f = str;
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f7533a);
        parcel.writeString(this.f7534b);
        parcel.writeString(this.f7535c);
        parcel.writeString(this.f7536d);
        parcel.writeString(this.f7537e);
        parcel.writeString(this.f7538f);
    }

    public Crossroad() {
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.f7533a = parcel.readFloat();
        this.f7534b = parcel.readString();
        this.f7535c = parcel.readString();
        this.f7536d = parcel.readString();
        this.f7537e = parcel.readString();
        this.f7538f = parcel.readString();
    }
}
