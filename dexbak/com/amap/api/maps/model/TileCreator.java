package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.amap.api.maps.model.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class TileCreator implements Parcelable.Creator<Tile> {
    /* renamed from: a */
    private static Tile m52010a(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readInt() == 1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile createFromParcel(Parcel parcel) {
        return m52010a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile[] newArray(int i) {
        return m52011a(i);
    }

    /* renamed from: a */
    private static Tile[] m52011a(int i) {
        return new Tile[i];
    }
}
