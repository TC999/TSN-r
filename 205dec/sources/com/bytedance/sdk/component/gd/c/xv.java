package com.bytedance.sdk.component.gd.c;

import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements Comparable<xv>, Runnable {

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f29836c;

    /* renamed from: w  reason: collision with root package name */
    private f f29837w;
    private boolean xv = true;
    private boolean sr = true;

    public xv(Runnable runnable) {
        this.f29836c = runnable;
    }

    private void xv(boolean z3) {
        f fVar = this.f29837w;
        if (fVar != null) {
            fVar.c(this, z3);
        }
    }

    public void c(f fVar) {
        this.f29837w = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Thread currentThread = Thread.currentThread();
        int priority = currentThread.getPriority();
        Runnable runnable = this.f29836c;
        if (runnable instanceof p) {
            try {
                currentThread.setPriority(Math.min(((p) runnable).c(), 10));
            } catch (Throwable th) {
                a.xv("BizRunnable", th);
            }
        }
        this.f29836c.run();
        try {
            currentThread.setPriority(priority);
        } catch (Throwable th2) {
            a.xv("BizRunnable", th2);
        }
        xv(false);
    }

    public void w(boolean z3) {
        this.sr = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Runnable c() {
        return this.f29836c;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(xv xvVar) {
        Class<?> cls = this.f29836c.getClass();
        Class<?> cls2 = xvVar.f29836c.getClass();
        if (cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls)) {
            Runnable runnable = this.f29836c;
            if (runnable instanceof Comparable) {
                Runnable runnable2 = xvVar.f29836c;
                if (runnable2 instanceof Comparable) {
                    return ((Comparable) runnable).compareTo(runnable2);
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    public xv(Runnable runnable, f fVar) {
        this.f29836c = runnable;
        this.f29837w = fVar;
    }

    public void c(boolean z3) {
        this.xv = z3;
    }
}
