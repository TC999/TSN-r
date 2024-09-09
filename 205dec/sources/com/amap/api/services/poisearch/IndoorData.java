package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new Parcelable.Creator<IndoorData>() { // from class: com.amap.api.services.poisearch.IndoorData.1
        private static IndoorData a(Parcel parcel) {
            return new IndoorData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ IndoorData[] newArray(int i4) {
            return a(i4);
        }

        private static IndoorData[] a(int i4) {
            return new IndoorData[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f11143a;

    /* renamed from: b  reason: collision with root package name */
    private int f11144b;

    /* renamed from: c  reason: collision with root package name */
    private String f11145c;

    public IndoorData(String str, int i4, String str2) {
        this.f11143a = str;
        this.f11144b = i4;
        this.f11145c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFloor() {
        return this.f11144b;
    }

    public String getFloorName() {
        return this.f11145c;
    }

    public String getPoiId() {
        return this.f11143a;
    }

    public void setFloor(int i4) {
        this.f11144b = i4;
    }

    public void setFloorName(String str) {
        this.f11145c = str;
    }

    public void setPoiId(String str) {
        this.f11143a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f11143a);
        parcel.writeInt(this.f11144b);
        parcel.writeString(this.f11145c);
    }

    protected IndoorData(Parcel parcel) {
        this.f11143a = parcel.readString();
        this.f11144b = parcel.readInt();
        this.f11145c = parcel.readString();
    }
}
