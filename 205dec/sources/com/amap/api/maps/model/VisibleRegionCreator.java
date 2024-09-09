package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(VisibleRegion visibleRegion, Parcel parcel, int i4) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i4);
        parcel.writeParcelable(visibleRegion.nearRight, i4);
        parcel.writeParcelable(visibleRegion.farLeft, i4);
        parcel.writeParcelable(visibleRegion.farRight, i4);
        parcel.writeParcelable(visibleRegion.latLngBounds, i4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        LatLngBounds latLngBounds;
        int readInt = parcel.readInt();
        try {
            latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            } catch (BadParcelableException e4) {
                e = e4;
                latLng2 = null;
                latLng3 = latLng2;
                latLng4 = latLng3;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
            }
            try {
                latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                    try {
                        latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                    } catch (BadParcelableException e5) {
                        e = e5;
                        e.printStackTrace();
                        latLngBounds = null;
                        return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
                    }
                } catch (BadParcelableException e6) {
                    e = e6;
                    latLng4 = null;
                }
            } catch (BadParcelableException e7) {
                e = e7;
                latLng3 = null;
                latLng4 = latLng3;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
            }
        } catch (BadParcelableException e8) {
            e = e8;
            latLng = null;
            latLng2 = null;
        }
        return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion[] newArray(int i4) {
        return new VisibleRegion[i4];
    }
}
