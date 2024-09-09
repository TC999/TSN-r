package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DistanceItem implements Parcelable {
    public static final Parcelable.Creator<DistanceItem> CREATOR = new Parcelable.Creator<DistanceItem>() { // from class: com.amap.api.services.route.DistanceItem.1
        private static DistanceItem a(Parcel parcel) {
            return new DistanceItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem[] newArray(int i4) {
            return a(i4);
        }

        private static DistanceItem[] a(int i4) {
            return new DistanceItem[i4];
        }
    };
    public final int ERROR_CODE_NOT_IN_CHINA;
    public final int ERROR_CODE_NO_DRIVE;
    public final int ERROR_CODE_TOO_FAR;

    /* renamed from: a  reason: collision with root package name */
    private int f11285a;

    /* renamed from: b  reason: collision with root package name */
    private int f11286b;

    /* renamed from: c  reason: collision with root package name */
    private float f11287c;

    /* renamed from: d  reason: collision with root package name */
    private float f11288d;

    /* renamed from: e  reason: collision with root package name */
    private String f11289e;

    /* renamed from: f  reason: collision with root package name */
    private int f11290f;

    public DistanceItem() {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f11285a = 1;
        this.f11286b = 1;
        this.f11287c = 0.0f;
        this.f11288d = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDestId() {
        return this.f11286b;
    }

    public float getDistance() {
        return this.f11287c;
    }

    public float getDuration() {
        return this.f11288d;
    }

    public int getErrorCode() {
        return this.f11290f;
    }

    public String getErrorInfo() {
        return this.f11289e;
    }

    public int getOriginId() {
        return this.f11285a;
    }

    public void setDestId(int i4) {
        this.f11286b = i4;
    }

    public void setDistance(float f4) {
        this.f11287c = f4;
    }

    public void setDuration(float f4) {
        this.f11288d = f4;
    }

    public void setErrorCode(int i4) {
        this.f11290f = i4;
    }

    public void setErrorInfo(String str) {
        this.f11289e = str;
    }

    public void setOriginId(int i4) {
        this.f11285a = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f11285a);
        parcel.writeInt(this.f11286b);
        parcel.writeFloat(this.f11287c);
        parcel.writeFloat(this.f11288d);
        parcel.writeString(this.f11289e);
        parcel.writeInt(this.f11290f);
    }

    protected DistanceItem(Parcel parcel) {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f11285a = 1;
        this.f11286b = 1;
        this.f11287c = 0.0f;
        this.f11288d = 0.0f;
        this.f11285a = parcel.readInt();
        this.f11286b = parcel.readInt();
        this.f11287c = parcel.readFloat();
        this.f11288d = parcel.readFloat();
        this.f11289e = parcel.readString();
        this.f11290f = parcel.readInt();
    }
}
