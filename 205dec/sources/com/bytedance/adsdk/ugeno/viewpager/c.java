package com.bytedance.adsdk.ugeno.viewpager;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private final Parcelable f26328a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f26327b = new c() { // from class: com.bytedance.adsdk.ugeno.viewpager.c.1
    };
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static class a implements Parcelable.ClassLoaderCreator<c> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b */
        public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return c.f26327b;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c */
        public c[] newArray(int i4) {
            return new c[i4];
        }
    }

    public final Parcelable b() {
        return this.f26328a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f26328a, i4);
    }

    private c() {
        this.f26328a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Parcelable parcelable) {
        if (parcelable != null) {
            this.f26328a = parcelable == f26327b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f26328a = readParcelable == null ? f26327b : readParcelable;
    }
}
