package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new a();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f54364a;

    /* renamed from: b  reason: collision with root package name */
    private final float f54365b;

    /* renamed from: c  reason: collision with root package name */
    private final float f54366c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class a implements Parcelable.Creator<AspectRatio> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AspectRatio[] newArray(int i4) {
            return new AspectRatio[i4];
        }
    }

    public AspectRatio(@Nullable String str, float f4, float f5) {
        this.f54364a = str;
        this.f54365b = f4;
        this.f54366c = f5;
    }

    @Nullable
    public String a() {
        return this.f54364a;
    }

    public float b() {
        return this.f54365b;
    }

    public float c() {
        return this.f54366c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f54364a);
        parcel.writeFloat(this.f54365b);
        parcel.writeFloat(this.f54366c);
    }

    protected AspectRatio(Parcel parcel) {
        this.f54364a = parcel.readString();
        this.f54365b = parcel.readFloat();
        this.f54366c = parcel.readFloat();
    }
}
