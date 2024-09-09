package cn.asus.push;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class b implements Parcelable.Creator<DataBuffer> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataBuffer createFromParcel(Parcel parcel) {
        return new DataBuffer(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DataBuffer[] newArray(int i4) {
        return new DataBuffer[i4];
    }
}
