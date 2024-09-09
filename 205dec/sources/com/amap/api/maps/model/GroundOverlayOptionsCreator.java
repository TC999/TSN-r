package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class GroundOverlayOptionsCreator implements Parcelable.Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions(readInt, (LatLng) parcel.readParcelable(LatLng.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader()), parcel.readFloat(), parcel.readFloat(), parcel.readByte() != 0, parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        groundOverlayOptions.image(bitmapDescriptor);
        return groundOverlayOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GroundOverlayOptions[] newArray(int i4) {
        return new GroundOverlayOptions[i4];
    }
}
