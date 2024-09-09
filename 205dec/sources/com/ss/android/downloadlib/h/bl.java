package com.ss.android.downloadlib.h;

import java.lang.ref.SoftReference;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl<P, R> implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private R f48836a;
    private int bl;
    private bl<R, ?> kf;

    /* renamed from: n  reason: collision with root package name */
    private bl<?, P> f48837n;
    private P ok;

    /* renamed from: s  reason: collision with root package name */
    private SoftReference<ok<P, R>> f48838s;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface ok<PARAM, RESULT> {
        RESULT ok(PARAM param);
    }

    private bl(int i4, ok<P, R> okVar, P p3) {
        this.bl = i4;
        this.f48838s = new SoftReference<>(okVar);
        this.ok = p3;
    }

    private R a() {
        return this.f48836a;
    }

    public static <P, R> bl<P, R> ok(ok<P, R> okVar, P p3) {
        return new bl<>(2, okVar, p3);
    }

    @Override // java.lang.Runnable
    public void run() {
        bl<?, P> blVar;
        if (this.bl == 0 && !j.a()) {
            com.ss.android.downloadlib.h.ok().a().post(this);
        } else if (this.bl == 1 && j.a()) {
            com.ss.android.downloadlib.s.ok().ok(this);
        } else if (this.bl == 2 && j.a()) {
            com.ss.android.downloadlib.s.ok().a(this);
        } else {
            if (this.ok == null && (blVar = this.f48837n) != null) {
                this.ok = blVar.a();
            }
            ok<P, R> okVar = this.f48838s.get();
            if (okVar == null) {
                return;
            }
            this.f48836a = okVar.ok(this.ok);
            bl<R, ?> blVar2 = this.kf;
            if (blVar2 != null) {
                blVar2.run();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <NR> bl<R, NR> ok(int i4, ok<R, NR> okVar) {
        bl blVar = (bl<R, ?>) new bl(i4, okVar, null);
        this.kf = blVar;
        blVar.f48837n = this;
        return blVar;
    }

    public <NR> bl<R, NR> ok(ok<R, NR> okVar) {
        return ok(0, okVar);
    }

    public void ok() {
        bl<?, P> blVar = this.f48837n;
        if (blVar != null) {
            blVar.ok();
        } else {
            run();
        }
    }
}
