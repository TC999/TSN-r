package com.bytedance.sdk.component.c;

import com.bytedance.component.sdk.annotation.CallSuper;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class sr<P, R> extends com.bytedance.sdk.component.c.w<P, R> {

    /* renamed from: c  reason: collision with root package name */
    private boolean f29712c = true;

    /* renamed from: w  reason: collision with root package name */
    private c f29713w;
    private f xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Object obj);

        void c(Throwable th);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        sr c();
    }

    private boolean r() {
        if (this.f29712c) {
            return true;
        }
        gd.c(new IllegalStateException("Jsb async call already finished: " + c() + ", hashcode: " + hashCode()));
        return false;
    }

    @Override // com.bytedance.sdk.component.c.w
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    protected abstract void c(P p3, f fVar) throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        sr();
        ux();
    }

    protected abstract void sr();

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void ux() {
        this.f29712c = false;
        this.xv = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void xv() {
        c((Throwable) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(R r3) {
        if (r()) {
            this.f29713w.c(r3);
            ux();
        }
    }

    protected final void c(Throwable th) {
        if (r()) {
            this.f29713w.c(th);
            ux();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(P p3, f fVar, c cVar) throws Exception {
        this.xv = fVar;
        this.f29713w = cVar;
        c(p3, fVar);
    }
}
