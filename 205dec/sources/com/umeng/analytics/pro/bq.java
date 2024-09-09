package com.umeng.analytics.pro;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TApplicationException.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bq extends bx {

    /* renamed from: a  reason: collision with root package name */
    public static final int f52725a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f52726b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f52727c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f52728d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f52729e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f52730f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static final int f52731g = 6;

    /* renamed from: h  reason: collision with root package name */
    public static final int f52732h = 7;

    /* renamed from: j  reason: collision with root package name */
    private static final cv f52733j = new cv("TApplicationException");

    /* renamed from: k  reason: collision with root package name */
    private static final cl f52734k = new cl("message", (byte) 11, 1);

    /* renamed from: l  reason: collision with root package name */
    private static final cl f52735l = new cl("type", (byte) 8, 2);

    /* renamed from: m  reason: collision with root package name */
    private static final long f52736m = 1;

    /* renamed from: i  reason: collision with root package name */
    protected int f52737i;

    public bq() {
        this.f52737i = 0;
    }

    public int a() {
        return this.f52737i;
    }

    public void b(cq cqVar) throws bx {
        cqVar.a(f52733j);
        if (getMessage() != null) {
            cqVar.a(f52734k);
            cqVar.a(getMessage());
            cqVar.c();
        }
        cqVar.a(f52735l);
        cqVar.a(this.f52737i);
        cqVar.c();
        cqVar.d();
        cqVar.b();
    }

    public static bq a(cq cqVar) throws bx {
        cqVar.j();
        String str = null;
        int i4 = 0;
        while (true) {
            cl l4 = cqVar.l();
            byte b4 = l4.f52815b;
            if (b4 == 0) {
                cqVar.k();
                return new bq(i4, str);
            }
            short s3 = l4.f52816c;
            if (s3 != 1) {
                if (s3 != 2) {
                    ct.a(cqVar, b4);
                } else if (b4 == 8) {
                    i4 = cqVar.w();
                } else {
                    ct.a(cqVar, b4);
                }
            } else if (b4 == 11) {
                str = cqVar.z();
            } else {
                ct.a(cqVar, b4);
            }
            cqVar.m();
        }
    }

    public bq(int i4) {
        this.f52737i = i4;
    }

    public bq(int i4, String str) {
        super(str);
        this.f52737i = i4;
    }

    public bq(String str) {
        super(str);
        this.f52737i = 0;
    }
}
