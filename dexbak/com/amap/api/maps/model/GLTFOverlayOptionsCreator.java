package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GLTFOverlayOptionsCreator implements Parcelable.Creator<GLTFOverlayOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GLTFOverlayOptions[] newArray(int i) {
        return new GLTFOverlayOptions[0];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GLTFOverlayOptions createFromParcel(Parcel parcel) {
        double readDouble = parcel.readDouble();
        double readDouble2 = parcel.readDouble();
        double readDouble3 = parcel.readDouble();
        GLTFOverlayOptions gLTFOverlayOptions = new GLTFOverlayOptions((LatLng) parcel.readParcelable(LatLng.class.getClassLoader()), parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readArrayList(GLTFResourceIterm.class.getClassLoader()));
        gLTFOverlayOptions.rotationDegree(readDouble2, readDouble3, readDouble);
        return gLTFOverlayOptions;
    }
}
