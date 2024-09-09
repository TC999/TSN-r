package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.a3;
import com.autonavi.base.ae.gmap.maploader.Pools;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@JBindingInclude
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class Tile implements Parcelable {
    public static final b CREATOR = new b();
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
    public Tile(int i4, int i5, int i6, byte[] bArr, boolean z3) {
        this.mVersionCode = i4;
        this.width = i5;
        this.height = i6;
        this.data = bArr;
        if (bArr != null) {
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(decodeByteArray);
                a3.B(decodeByteArray);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.isBitmap = z3;
    }

    public static Tile obtain(int i4, int i5, byte[] bArr) {
        Tile acquire = M_POOL.acquire();
        return acquire != null ? acquire : new Tile(i4, i5, bArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void recycle() {
        M_POOL.release(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
        parcel.writeInt(this.isBitmap ? 1 : 0);
    }

    public Tile(int i4, int i5, byte[] bArr) {
        this(1, i4, i5, bArr, true);
    }

    public Tile(int i4, int i5, byte[] bArr, boolean z3) {
        this(1, i4, i5, bArr, z3);
    }
}
