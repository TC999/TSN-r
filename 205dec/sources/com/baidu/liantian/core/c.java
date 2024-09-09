package com.baidu.liantian.core;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: CallArgs.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.baidu.liantian.core.c.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ c[] newArray(int i4) {
            return new c[i4];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f12168a;

    /* renamed from: b  reason: collision with root package name */
    public int f12169b;

    /* renamed from: c  reason: collision with root package name */
    public String f12170c;

    /* renamed from: d  reason: collision with root package name */
    public Object[] f12171d;

    /* renamed from: e  reason: collision with root package name */
    public Object[] f12172e;

    /* renamed from: f  reason: collision with root package name */
    public Object f12173f;

    public c() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f12168a);
        parcel.writeInt(this.f12169b);
        parcel.writeString(this.f12170c);
        parcel.writeArray(this.f12172e);
        parcel.writeArray(this.f12171d);
        parcel.writeValue(this.f12173f);
    }

    protected c(Parcel parcel) {
        this.f12168a = parcel.readInt();
        this.f12169b = parcel.readInt();
        this.f12170c = parcel.readString();
        this.f12172e = parcel.readArray(c.class.getClassLoader());
        this.f12171d = parcel.readArray(c.class.getClassLoader());
        this.f12173f = parcel.readValue(c.class.getClassLoader());
    }
}
