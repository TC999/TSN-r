package com.scwang.smartrefresh.layout.util;

/* renamed from: com.scwang.smartrefresh.layout.util.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DelayedRunable implements Runnable {

    /* renamed from: a */
    public long f33743a;

    /* renamed from: b */
    public Runnable f33744b;

    public DelayedRunable(Runnable runnable) {
        this.f33744b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Runnable runnable = this.f33744b;
            if (runnable != null) {
                runnable.run();
                this.f33744b = null;
            }
        } catch (Throwable unused) {
        }
    }

    public DelayedRunable(Runnable runnable, long j) {
        this.f33744b = runnable;
        this.f33743a = j;
    }
}
