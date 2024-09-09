package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TileCreator.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class b implements Parcelable.Creator<Tile> {
    private static Tile a(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readInt() == 1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile[] newArray(int i4) {
        return a(i4);
    }

    private static Tile[] a(int i4) {
        return new Tile[i4];
    }
}
