package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class IndoorDataV2 implements Parcelable {
    public static final Parcelable.Creator<IndoorDataV2> CREATOR = new Parcelable.Creator<IndoorDataV2>() { // from class: com.amap.api.services.poisearch.IndoorDataV2.1
        private static IndoorDataV2 a(Parcel parcel) {
            return new IndoorDataV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2[] newArray(int i4) {
            return a(i4);
        }

        private static IndoorDataV2[] a(int i4) {
            return new IndoorDataV2[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private boolean f11146a;

    /* renamed from: b  reason: collision with root package name */
    private String f11147b;

    /* renamed from: c  reason: collision with root package name */
    private int f11148c;

    /* renamed from: d  reason: collision with root package name */
    private String f11149d;

    public IndoorDataV2(boolean z3, String str, int i4, String str2) {
        this.f11146a = z3;
        this.f11147b = str;
        this.f11148c = i4;
        this.f11149d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f11148c;
    }

    public String getFloorName() {
        return this.f11149d;
    }

    public String getPoiId() {
        return this.f11147b;
    }

    public boolean isIndoorMap() {
        return this.f11146a;
    }

    public void setFloor(int i4) {
        this.f11148c = i4;
    }

    public void setFloorName(String str) {
        this.f11149d = str;
    }

    public void setIndoorMap(boolean z3) {
        this.f11146a = z3;
    }

    public void setPoiId(String str) {
        this.f11147b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeBooleanArray(new boolean[]{this.f11146a});
        parcel.writeString(this.f11147b);
        parcel.writeInt(this.f11148c);
        parcel.writeString(this.f11149d);
    }

    protected IndoorDataV2(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f11146a = zArr[0];
        this.f11147b = parcel.readString();
        this.f11148c = parcel.readInt();
        this.f11149d = parcel.readString();
    }
}
