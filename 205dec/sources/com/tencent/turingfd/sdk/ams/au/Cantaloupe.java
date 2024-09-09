package com.tencent.turingfd.sdk.ams.au;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cantaloupe implements Parcelable {

    /* renamed from: c  reason: collision with root package name */
    public int f51942c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f51943d;

    /* renamed from: e  reason: collision with root package name */
    public int f51944e;

    public Cantaloupe(Parcel parcel) {
        this.f51942c = parcel.readInt();
        this.f51943d = parcel.createByteArray();
        this.f51944e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f51942c);
        parcel.writeByteArray(this.f51943d);
        parcel.writeInt(this.f51944e);
    }
}
