package com.amap.api.col.p0003l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AMapRecallLogUpdateStrategy.java */
/* renamed from: com.amap.api.col.3l.c5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c5 extends w7 {

    /* renamed from: h  reason: collision with root package name */
    private static int f7316h = 10000000;

    /* renamed from: b  reason: collision with root package name */
    protected int f7317b;

    /* renamed from: c  reason: collision with root package name */
    protected long f7318c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7319d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7320e;

    /* renamed from: f  reason: collision with root package name */
    private int f7321f;

    /* renamed from: g  reason: collision with root package name */
    private long f7322g;

    public c5(boolean z3, w7 w7Var, long j4, int i4) {
        super(w7Var);
        this.f7320e = false;
        this.f7319d = z3;
        this.f7317b = 600000;
        this.f7322g = j4;
        this.f7321f = i4;
    }

    @Override // com.amap.api.col.p0003l.w7
    public final int a() {
        return 320000;
    }

    @Override // com.amap.api.col.p0003l.w7
    protected final boolean d() {
        if (!this.f7320e || this.f7322g > this.f7321f) {
            if (this.f7319d && this.f7322g < this.f7321f) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f7318c < this.f7317b) {
                    return false;
                }
                this.f7318c = currentTimeMillis;
                return true;
            }
            return false;
        }
        return true;
    }

    public final void f(int i4) {
        if (i4 <= 0) {
            return;
        }
        this.f7322g += i4;
    }

    public final void g(boolean z3) {
        this.f7320e = z3;
    }

    public final long h() {
        return this.f7322g;
    }
}
