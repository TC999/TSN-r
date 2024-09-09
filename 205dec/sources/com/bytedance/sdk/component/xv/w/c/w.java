package com.bytedance.sdk.component.xv.w.c;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class w implements Runnable {

    /* renamed from: w  reason: collision with root package name */
    protected final String f30910w;

    public w(String str, Object... objArr) {
        this.f30910w = xv.c(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread currentThread = Thread.currentThread();
        currentThread.setName("csj_" + this.f30910w);
        try {
            xv();
        } finally {
            Thread.currentThread().setName(name);
        }
    }

    protected abstract void xv();
}
