package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0463l.C1732a3;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.p048ae.gmap.maploader.Pools;

@JBindingInclude
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Tile implements Parcelable {
    public static final TileCreator CREATOR = new TileCreator();
    private static final Pools.SynchronizedPool<Tile> M_POOL = new Pools.SynchronizedPool<>(18);
    @JBindingInclude
    private BitmapDescriptor bitmapDescriptor;
    @JBindingInclude
    public final byte[] data;
    @JBindingInclude
    public final int height;
    @JBindingInclude
    private final boolean isBitmap;
    @JBindingInclude
    private final int mVersionCode;
    @JBindingInclude
    public final int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tile(int i, int i2, int i3, byte[] bArr, boolean z) {
        this.mVersionCode = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
        if (bArr != null) {
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(decodeByteArray);
                C1732a3.m55743B(decodeByteArray);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.isBitmap = z;
    }

    public static Tile obtain(int i, int i2, byte[] bArr) {
        Tile acquire = M_POOL.acquire();
        return acquire != null ? acquire : new Tile(i, i2, bArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void recycle() {
        M_POOL.release(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
        parcel.writeInt(this.isBitmap ? 1 : 0);
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr, true);
    }

    public Tile(int i, int i2, byte[] bArr, boolean z) {
        this(1, i, i2, bArr, z);
    }
}
