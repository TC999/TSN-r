package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class TileProjection implements Parcelable {
    public static final TileProjection CREATOR = new TileProjection(0, 0, 0, 0, 0, 0);
    public final int maxX;
    public final int maxY;
    public final int minX;
    public final int minY;
    public final int offsetX;
    public final int offsetY;

    public TileProjection(int i4, int i5, int i6, int i7, int i8, int i9) {
        this.offsetX = i4;
        this.offsetY = i5;
        this.minX = i6;
        this.maxX = i7;
        this.minY = i8;
        this.maxY = i9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.offsetX);
        parcel.writeInt(this.offsetY);
        parcel.writeInt(this.minX);
        parcel.writeInt(this.maxX);
        parcel.writeInt(this.maxX);
        parcel.writeInt(this.maxY);
    }
}
