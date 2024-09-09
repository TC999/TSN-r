package com.bytedance.embedapplog;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class bk {

    /* renamed from: c  reason: collision with root package name */
    final ys f26705c;
    private volatile boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private int f26706w = 0;
    private boolean xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(ys ysVar) {
        this.f26705c = ysVar;
    }

    abstract long c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ev() {
        be.c("setImmediately, " + sr());
        this.sr = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        return this.xv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long r() {
        boolean z3;
        long j4;
        long c4 = c();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.sr) {
            c4 = 0;
            this.sr = false;
        }
        if (c4 <= 1000 + currentTimeMillis) {
            try {
                z3 = xv();
            } catch (Exception e4) {
                be.w(e4);
                z3 = false;
            }
            if (z3) {
                this.f26706w = 0;
                j4 = c() - System.currentTimeMillis();
            } else {
                long[] w3 = w();
                int i4 = this.f26706w;
                this.f26706w = i4 + 1;
                j4 = w3[i4 % w3.length];
            }
            be.sr(sr() + " worked:" + z3 + " " + j4, null);
            return j4;
        }
        return c4 - currentTimeMillis;
    }

    abstract String sr();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ux() {
        this.xv = true;
    }

    abstract long[] w();

    abstract boolean xv();
}
