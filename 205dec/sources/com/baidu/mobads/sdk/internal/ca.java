package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class ca implements Parcelable.Creator<bz> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bz createFromParcel(Parcel parcel) {
        return new bz(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bz[] newArray(int i4) {
        return new bz[i4];
    }
}
