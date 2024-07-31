package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DistanceItem implements Parcelable {
    public static final Parcelable.Creator<DistanceItem> CREATOR = new Parcelable.Creator<DistanceItem>() { // from class: com.amap.api.services.route.DistanceItem.1
        /* renamed from: a */
        private static DistanceItem m51832a(Parcel parcel) {
            return new DistanceItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem createFromParcel(Parcel parcel) {
            return m51832a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem[] newArray(int i) {
            return m51833a(i);
        }

        /* renamed from: a */
        private static DistanceItem[] m51833a(int i) {
            return new DistanceItem[i];
        }
    };
    public final int ERROR_CODE_NOT_IN_CHINA;
    public final int ERROR_CODE_NO_DRIVE;
    public final int ERROR_CODE_TOO_FAR;

    /* renamed from: a */
    private int f7591a;

    /* renamed from: b */
    private int f7592b;

    /* renamed from: c */
    private float f7593c;

    /* renamed from: d */
    private float f7594d;

    /* renamed from: e */
    private String f7595e;

    /* renamed from: f */
    private int f7596f;

    public DistanceItem() {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f7591a = 1;
        this.f7592b = 1;
        this.f7593c = 0.0f;
        this.f7594d = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDestId() {
        return this.f7592b;
    }

    public float getDistance() {
        return this.f7593c;
    }

    public float getDuration() {
        return this.f7594d;
    }

    public int getErrorCode() {
        return this.f7596f;
    }

    public String getErrorInfo() {
        return this.f7595e;
    }

    public int getOriginId() {
        return this.f7591a;
    }

    public void setDestId(int i) {
        this.f7592b = i;
    }

    public void setDistance(float f) {
        this.f7593c = f;
    }

    public void setDuration(float f) {
        this.f7594d = f;
    }

    public void setErrorCode(int i) {
        this.f7596f = i;
    }

    public void setErrorInfo(String str) {
        this.f7595e = str;
    }

    public void setOriginId(int i) {
        this.f7591a = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7591a);
        parcel.writeInt(this.f7592b);
        parcel.writeFloat(this.f7593c);
        parcel.writeFloat(this.f7594d);
        parcel.writeString(this.f7595e);
        parcel.writeInt(this.f7596f);
    }

    protected DistanceItem(Parcel parcel) {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f7591a = 1;
        this.f7592b = 1;
        this.f7593c = 0.0f;
        this.f7594d = 0.0f;
        this.f7591a = parcel.readInt();
        this.f7592b = parcel.readInt();
        this.f7593c = parcel.readFloat();
        this.f7594d = parcel.readFloat();
        this.f7595e = parcel.readString();
        this.f7596f = parcel.readInt();
    }
}
