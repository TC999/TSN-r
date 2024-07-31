package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new C13524a();
    @Nullable

    /* renamed from: a */
    private final String f39828a;

    /* renamed from: b */
    private final float f39829b;

    /* renamed from: c */
    private final float f39830c;

    /* renamed from: com.yalantis.ucrop.model.AspectRatio$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C13524a implements Parcelable.Creator<AspectRatio> {
        C13524a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }
    }

    public AspectRatio(@Nullable String str, float f, float f2) {
        this.f39828a = str;
        this.f39829b = f;
        this.f39830c = f2;
    }

    @Nullable
    /* renamed from: a */
    public String m13052a() {
        return this.f39828a;
    }

    /* renamed from: b */
    public float m13051b() {
        return this.f39829b;
    }

    /* renamed from: c */
    public float m13050c() {
        return this.f39830c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f39828a);
        parcel.writeFloat(this.f39829b);
        parcel.writeFloat(this.f39830c);
    }

    protected AspectRatio(Parcel parcel) {
        this.f39828a = parcel.readString();
        this.f39829b = parcel.readFloat();
        this.f39830c = parcel.readFloat();
    }
}
