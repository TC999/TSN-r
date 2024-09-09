package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Date implements Caelum {

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f52016j = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    public final String f52017a;

    /* renamed from: b  reason: collision with root package name */
    public final long f52018b;

    /* renamed from: c  reason: collision with root package name */
    public final int f52019c;

    /* renamed from: d  reason: collision with root package name */
    public final String f52020d;

    /* renamed from: e  reason: collision with root package name */
    public final String f52021e;

    /* renamed from: f  reason: collision with root package name */
    public final String f52022f;

    /* renamed from: g  reason: collision with root package name */
    public final String f52023g;

    /* renamed from: h  reason: collision with root package name */
    public int f52024h;

    /* renamed from: i  reason: collision with root package name */
    public int f52025i;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Date$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class Cdo {

        /* renamed from: a  reason: collision with root package name */
        public String f52026a;

        /* renamed from: b  reason: collision with root package name */
        public long f52027b;

        /* renamed from: c  reason: collision with root package name */
        public int f52028c;

        /* renamed from: d  reason: collision with root package name */
        public String f52029d;

        /* renamed from: e  reason: collision with root package name */
        public String f52030e;

        /* renamed from: f  reason: collision with root package name */
        public String f52031f;

        /* renamed from: g  reason: collision with root package name */
        public String f52032g;

        public Cdo(int i4) {
            this.f52028c = i4;
        }
    }

    public Date(int i4, byte[] bArr, int i5, int i6) {
        this.f52024h = 0;
        this.f52025i = 0;
        this.f52017a = "";
        this.f52018b = 0L;
        this.f52019c = i4;
        this.f52020d = "";
        this.f52021e = "";
        this.f52022f = "";
        this.f52023g = "";
        this.f52024h = i5;
        this.f52025i = i6;
    }

    public static Date a(int i4) {
        return new Date(i4, f52016j, 0, 0);
    }

    public Date(Cdo cdo) {
        this.f52024h = 0;
        this.f52025i = 0;
        this.f52017a = cdo.f52026a;
        this.f52018b = cdo.f52027b;
        this.f52019c = cdo.f52028c;
        this.f52020d = cdo.f52029d;
        this.f52021e = cdo.f52030e;
        this.f52022f = cdo.f52031f;
        this.f52023g = cdo.f52032g;
    }
}
