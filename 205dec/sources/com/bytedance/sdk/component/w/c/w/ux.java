package com.bytedance.sdk.component.w.c.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class ux implements Runnable {

    /* renamed from: w  reason: collision with root package name */
    protected final String f30449w;

    public ux(String str, Object... objArr) {
        this.f30449w = p.c(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread currentThread = Thread.currentThread();
        currentThread.setName("csj_" + this.f30449w);
        try {
            w();
        } finally {
            Thread.currentThread().setName(name);
        }
    }

    protected abstract void w();
}
