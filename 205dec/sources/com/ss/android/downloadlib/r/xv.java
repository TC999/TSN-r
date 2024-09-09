package com.ss.android.downloadlib.r;

import java.lang.ref.SoftReference;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv<P, R> implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private P f48933c;

    /* renamed from: f  reason: collision with root package name */
    private xv<R, ?> f48934f;
    private SoftReference<c<P, R>> sr;
    private xv<?, P> ux;

    /* renamed from: w  reason: collision with root package name */
    private R f48935w;
    private int xv;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface c<PARAM, RESULT> {
        RESULT c(PARAM param);
    }

    private xv(int i4, c<P, R> cVar, P p3) {
        this.xv = i4;
        this.sr = new SoftReference<>(cVar);
        this.f48933c = p3;
    }

    public static <P, R> xv<P, R> c(c<P, R> cVar, P p3) {
        return new xv<>(2, cVar, p3);
    }

    private R w() {
        return this.f48935w;
    }

    @Override // java.lang.Runnable
    public void run() {
        xv<?, P> xvVar;
        if (this.xv == 0 && !a.w()) {
            com.ss.android.downloadlib.r.c().w().post(this);
        } else if (this.xv == 1 && a.w()) {
            com.ss.android.downloadlib.sr.c().c(this);
        } else if (this.xv == 2 && a.w()) {
            com.ss.android.downloadlib.sr.c().w(this);
        } else {
            if (this.f48933c == null && (xvVar = this.ux) != null) {
                this.f48933c = xvVar.w();
            }
            c<P, R> cVar = this.sr.get();
            if (cVar == null) {
                return;
            }
            this.f48935w = cVar.c(this.f48933c);
            xv<R, ?> xvVar2 = this.f48934f;
            if (xvVar2 != null) {
                xvVar2.run();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> xv<R, NR> c(int i4, c<R, NR> cVar) {
        xv xvVar = (xv<R, ?>) new xv(i4, cVar, null);
        this.f48934f = xvVar;
        xvVar.ux = this;
        return xvVar;
    }

    public <NR> xv<R, NR> c(c<R, NR> cVar) {
        return c(0, cVar);
    }

    public void c() {
        xv<?, P> xvVar = this.ux;
        if (xvVar != null) {
            xvVar.c();
        } else {
            run();
        }
    }
}
