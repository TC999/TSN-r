package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class IndoorDataV2 implements Parcelable {
    public static final Parcelable.Creator<IndoorDataV2> CREATOR = new Parcelable.Creator<IndoorDataV2>() { // from class: com.amap.api.services.poisearch.IndoorDataV2.1
        /* renamed from: a */
        private static IndoorDataV2 m51861a(Parcel parcel) {
            return new IndoorDataV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2 createFromParcel(Parcel parcel) {
            return m51861a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorDataV2[] newArray(int i) {
            return m51862a(i);
        }

        /* renamed from: a */
        private static IndoorDataV2[] m51862a(int i) {
            return new IndoorDataV2[i];
        }
    };

    /* renamed from: a */
    private boolean f7452a;

    /* renamed from: b */
    private String f7453b;

    /* renamed from: c */
    private int f7454c;

    /* renamed from: d */
    private String f7455d;

    public IndoorDataV2(boolean z, String str, int i, String str2) {
        this.f7452a = z;
        this.f7453b = str;
        this.f7454c = i;
        this.f7455d = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f7454c;
    }

    public String getFloorName() {
        return this.f7455d;
    }

    public String getPoiId() {
        return this.f7453b;
    }

    public boolean isIndoorMap() {
        return this.f7452a;
    }

    public void setFloor(int i) {
        this.f7454c = i;
    }

    public void setFloorName(String str) {
        this.f7455d = str;
    }

    public void setIndoorMap(boolean z) {
        this.f7452a = z;
    }

    public void setPoiId(String str) {
        this.f7453b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.f7452a});
        parcel.writeString(this.f7453b);
        parcel.writeInt(this.f7454c);
        parcel.writeString(this.f7455d);
    }

    protected IndoorDataV2(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f7452a = zArr[0];
        this.f7453b = parcel.readString();
        this.f7454c = parcel.readInt();
        this.f7455d = parcel.readString();
    }
}
