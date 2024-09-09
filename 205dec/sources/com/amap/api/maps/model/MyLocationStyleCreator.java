package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class MyLocationStyleCreator implements Parcelable.Creator<MyLocationStyle> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MyLocationStyle createFromParcel(Parcel parcel) {
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon((BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader()));
        myLocationStyle.anchor(parcel.readFloat(), parcel.readFloat());
        myLocationStyle.radiusFillColor(parcel.readInt());
        myLocationStyle.strokeColor(parcel.readInt());
        myLocationStyle.strokeWidth(parcel.readFloat());
        myLocationStyle.myLocationType(parcel.readInt());
        myLocationStyle.interval(parcel.readLong());
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        myLocationStyle.showMyLocation(zArr[0]);
        return myLocationStyle;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MyLocationStyle[] newArray(int i4) {
        return new MyLocationStyle[i4];
    }
}