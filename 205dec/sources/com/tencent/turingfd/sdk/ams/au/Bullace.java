package com.tencent.turingfd.sdk.ams.au;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Bullace {

    /* renamed from: a  reason: collision with root package name */
    public int f51934a;

    /* renamed from: b  reason: collision with root package name */
    public int f51935b;

    /* renamed from: c  reason: collision with root package name */
    public long f51936c;

    /* renamed from: d  reason: collision with root package name */
    public String f51937d;

    /* renamed from: e  reason: collision with root package name */
    public int f51938e;

    /* renamed from: f  reason: collision with root package name */
    public int f51939f;

    public Bullace(int i4, int i5, long j4, String str, int i6, int i7) {
        this.f51934a = -1;
        this.f51935b = -1;
        this.f51936c = -1L;
        this.f51937d = "";
        this.f51938e = -1;
        this.f51939f = -1;
        this.f51934a = i4;
        this.f51935b = i5;
        this.f51936c = j4;
        this.f51937d = str;
        this.f51938e = i6;
        this.f51939f = i7;
    }

    public static Bullace a(int i4) {
        return new Bullace(i4, 100, -1L, "", -1, -2);
    }

    public String toString() {
        return this.f51934a + "_" + this.f51935b + "_" + this.f51936c + "_" + this.f51938e + "_" + this.f51937d + "_" + this.f51939f;
    }

    public static Bullace a(int i4, int i5) {
        return new Bullace(i4, 200, -1L, "", -1, i5);
    }
}
