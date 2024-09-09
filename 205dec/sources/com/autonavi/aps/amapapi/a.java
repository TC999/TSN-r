package com.autonavi.aps.amapapi;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapLocationStaticsEntity.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.autonavi.aps.amapapi.a.1
        private static a a(Parcel parcel) {
            a aVar = new a();
            aVar.c(parcel.readString());
            aVar.d(parcel.readString());
            aVar.e(parcel.readString());
            aVar.f(parcel.readString());
            aVar.b(parcel.readString());
            aVar.c(parcel.readLong());
            aVar.d(parcel.readLong());
            aVar.a(parcel.readLong());
            aVar.b(parcel.readLong());
            aVar.a(parcel.readString());
            return aVar;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a[] newArray(int i4) {
            return a(i4);
        }

        private static a[] a(int i4) {
            return new a[i4];
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private String f11679e;

    /* renamed from: f  reason: collision with root package name */
    private String f11680f;

    /* renamed from: a  reason: collision with root package name */
    private long f11675a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f11676b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f11677c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f11678d = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f11681g = "first";

    /* renamed from: h  reason: collision with root package name */
    private String f11682h = "";

    /* renamed from: i  reason: collision with root package name */
    private String f11683i = "";

    /* renamed from: j  reason: collision with root package name */
    private String f11684j = null;

    public final long a() {
        long j4 = this.f11678d;
        long j5 = this.f11677c;
        if (j4 - j5 <= 0) {
            return 0L;
        }
        return j4 - j5;
    }

    public final String b() {
        return this.f11683i;
    }

    public final void c(long j4) {
        this.f11675a = j4;
    }

    public final void d(long j4) {
        this.f11676b = j4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f11680f;
    }

    public final String f() {
        return this.f11681g;
    }

    public final String g() {
        return this.f11682h;
    }

    public final long h() {
        long j4 = this.f11676b;
        long j5 = this.f11675a;
        if (j4 <= j5) {
            return 0L;
        }
        return j4 - j5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        try {
            parcel.writeString(this.f11679e);
            parcel.writeString(this.f11680f);
            parcel.writeString(this.f11681g);
            parcel.writeString(this.f11682h);
            parcel.writeString(this.f11684j);
            parcel.writeLong(this.f11675a);
            parcel.writeLong(this.f11676b);
            parcel.writeLong(this.f11677c);
            parcel.writeLong(this.f11678d);
            parcel.writeString(this.f11683i);
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        this.f11683i = str;
    }

    public final void b(long j4) {
        this.f11678d = j4;
    }

    public final String c() {
        return this.f11684j;
    }

    public final String d() {
        return this.f11679e;
    }

    public final void e(String str) {
        this.f11681g = str;
    }

    public final void f(String str) {
        this.f11682h = str;
    }

    public final void a(long j4) {
        this.f11677c = j4;
    }

    public final void b(String str) {
        this.f11684j = str;
    }

    public final void c(String str) {
        this.f11679e = str;
    }

    public final void d(String str) {
        this.f11680f = str;
    }
}
