package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CircleOptions createFromParcel(Parcel parcel) {
        CircleOptions circleOptions = new CircleOptions();
        Bundle readBundle = parcel.readBundle();
        circleOptions.center(new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng")));
        circleOptions.radius(parcel.readDouble());
        circleOptions.strokeWidth(parcel.readFloat());
        circleOptions.strokeColor(parcel.readInt());
        circleOptions.fillColor(parcel.readInt());
        circleOptions.zIndex(parcel.readFloat());
        circleOptions.visible(parcel.readByte() == 1);
        circleOptions.f10732a = parcel.readString();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, BaseHoleOptions.class.getClassLoader());
        circleOptions.addHoles(arrayList);
        circleOptions.setStrokeDottedLineType(parcel.readInt());
        circleOptions.usePolylineStroke(parcel.readByte() == 1);
        return circleOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CircleOptions[] newArray(int i4) {
        return new CircleOptions[i4];
    }
}
