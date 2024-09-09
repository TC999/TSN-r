package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(LatLngBounds latLngBounds, Parcel parcel, int i4) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i4);
        parcel.writeParcelable(latLngBounds.northeast, i4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        int readInt = parcel.readInt();
        LatLng latLng2 = null;
        try {
            latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            } catch (BadParcelableException e4) {
                e = e4;
                e.printStackTrace();
                return new LatLngBounds(readInt, latLng, latLng2);
            }
        } catch (BadParcelableException e5) {
            e = e5;
            latLng = null;
        }
        return new LatLngBounds(readInt, latLng, latLng2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds[] newArray(int i4) {
        return new LatLngBounds[i4];
    }
}
