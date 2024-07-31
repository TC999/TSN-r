package com.autonavi.aps.amapapi;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.autonavi.aps.amapapi.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AMapLocationStaticsEntity implements Parcelable {
    public static final Parcelable.Creator<AMapLocationStaticsEntity> CREATOR = new Parcelable.Creator<AMapLocationStaticsEntity>() { // from class: com.autonavi.aps.amapapi.a.1
        /* renamed from: a */
        private static AMapLocationStaticsEntity m51718a(Parcel parcel) {
            AMapLocationStaticsEntity aMapLocationStaticsEntity = new AMapLocationStaticsEntity();
            aMapLocationStaticsEntity.m51729c(parcel.readString());
            aMapLocationStaticsEntity.m51726d(parcel.readString());
            aMapLocationStaticsEntity.m51724e(parcel.readString());
            aMapLocationStaticsEntity.m51722f(parcel.readString());
            aMapLocationStaticsEntity.m51732b(parcel.readString());
            aMapLocationStaticsEntity.m51730c(parcel.readLong());
            aMapLocationStaticsEntity.m51727d(parcel.readLong());
            aMapLocationStaticsEntity.m51736a(parcel.readLong());
            aMapLocationStaticsEntity.m51733b(parcel.readLong());
            aMapLocationStaticsEntity.m51735a(parcel.readString());
            return aMapLocationStaticsEntity;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationStaticsEntity createFromParcel(Parcel parcel) {
            return m51718a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AMapLocationStaticsEntity[] newArray(int i) {
            return m51719a(i);
        }

        /* renamed from: a */
        private static AMapLocationStaticsEntity[] m51719a(int i) {
            return new AMapLocationStaticsEntity[i];
        }
    };

    /* renamed from: e */
    private String f7985e;

    /* renamed from: f */
    private String f7986f;

    /* renamed from: a */
    private long f7981a = 0;

    /* renamed from: b */
    private long f7982b = 0;

    /* renamed from: c */
    private long f7983c = 0;

    /* renamed from: d */
    private long f7984d = 0;

    /* renamed from: g */
    private String f7987g = "first";

    /* renamed from: h */
    private String f7988h = "";

    /* renamed from: i */
    private String f7989i = "";

    /* renamed from: j */
    private String f7990j = null;

    /* renamed from: a */
    public final long m51737a() {
        long j = this.f7984d;
        long j2 = this.f7983c;
        if (j - j2 <= 0) {
            return 0L;
        }
        return j - j2;
    }

    /* renamed from: b */
    public final String m51734b() {
        return this.f7989i;
    }

    /* renamed from: c */
    public final void m51730c(long j) {
        this.f7981a = j;
    }

    /* renamed from: d */
    public final void m51727d(long j) {
        this.f7982b = j;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public final String m51725e() {
        return this.f7986f;
    }

    /* renamed from: f */
    public final String m51723f() {
        return this.f7987g;
    }

    /* renamed from: g */
    public final String m51721g() {
        return this.f7988h;
    }

    /* renamed from: h */
    public final long m51720h() {
        long j = this.f7982b;
        long j2 = this.f7981a;
        if (j <= j2) {
            return 0L;
        }
        return j - j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeString(this.f7985e);
            parcel.writeString(this.f7986f);
            parcel.writeString(this.f7987g);
            parcel.writeString(this.f7988h);
            parcel.writeString(this.f7990j);
            parcel.writeLong(this.f7981a);
            parcel.writeLong(this.f7982b);
            parcel.writeLong(this.f7983c);
            parcel.writeLong(this.f7984d);
            parcel.writeString(this.f7989i);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public final void m51735a(String str) {
        this.f7989i = str;
    }

    /* renamed from: b */
    public final void m51733b(long j) {
        this.f7984d = j;
    }

    /* renamed from: c */
    public final String m51731c() {
        return this.f7990j;
    }

    /* renamed from: d */
    public final String m51728d() {
        return this.f7985e;
    }

    /* renamed from: e */
    public final void m51724e(String str) {
        this.f7987g = str;
    }

    /* renamed from: f */
    public final void m51722f(String str) {
        this.f7988h = str;
    }

    /* renamed from: a */
    public final void m51736a(long j) {
        this.f7983c = j;
    }

    /* renamed from: b */
    public final void m51732b(String str) {
        this.f7990j = str;
    }

    /* renamed from: c */
    public final void m51729c(String str) {
        this.f7985e = str;
    }

    /* renamed from: d */
    public final void m51726d(String str) {
        this.f7986f = str;
    }
}
