package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BitmapDescriptorCreator implements Parcelable.Creator<BitmapDescriptor> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null, parcel.readString());
        bitmapDescriptor.mBitmap = parcel.readParcelable(Bitmap.class.getClassLoader());
        bitmapDescriptor.f10728a = parcel.readInt();
        bitmapDescriptor.f10729b = parcel.readInt();
        return bitmapDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor[] newArray(int i4) {
        return new BitmapDescriptor[i4];
    }
}
