package com.mbridge.msdk.foundation.same.net;

/* compiled from: DefaultRetryPolicy.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements l {

    /* renamed from: a  reason: collision with root package name */
    private int f39486a;

    /* renamed from: b  reason: collision with root package name */
    private int f39487b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39488c;

    /* renamed from: d  reason: collision with root package name */
    private int f39489d;

    /* renamed from: e  reason: collision with root package name */
    private int f39490e;

    /* renamed from: f  reason: collision with root package name */
    private int f39491f;

    /* renamed from: g  reason: collision with root package name */
    private int f39492g;

    /* renamed from: h  reason: collision with root package name */
    private int f39493h;

    public b() {
        this(30000, 0);
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int a() {
        return this.f39488c;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int b() {
        return this.f39486a;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int c() {
        return this.f39487b;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int d() {
        return this.f39490e;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int e() {
        return this.f39491f;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int f() {
        return this.f39492g;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final int g() {
        return this.f39493h;
    }

    public b(int i4, int i5) {
        this.f39489d = 2;
        this.f39490e = 0;
        this.f39491f = 0;
        this.f39492g = 0;
        this.f39493h = 0;
        this.f39486a = i4 <= 0 ? 30000 : i4;
        this.f39488c = i5;
    }

    @Override // com.mbridge.msdk.foundation.same.net.l
    public final boolean a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
        int i4 = this.f39487b + 1;
        this.f39487b = i4;
        return i4 <= this.f39488c;
    }

    public b(int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f39489d = 2;
        this.f39490e = 0;
        this.f39491f = 0;
        this.f39492g = 0;
        this.f39493h = 0;
        this.f39490e = Math.max(i4, 0);
        this.f39491f = Math.max(i5, 0);
        this.f39492g = Math.max(i6, 0);
        this.f39493h = Math.max(i7, 0);
        this.f39488c = Math.max(i8, 0);
        this.f39489d = i9;
    }
}
