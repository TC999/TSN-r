package com.scwang.smartrefresh.layout.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DelayedRunable.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public long f48077a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f48078b;

    public b(Runnable runnable) {
        this.f48078b = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Runnable runnable = this.f48078b;
            if (runnable != null) {
                runnable.run();
                this.f48078b = null;
            }
        } catch (Throwable unused) {
        }
    }

    public b(Runnable runnable, long j4) {
        this.f48078b = runnable;
        this.f48077a = j4;
    }
}
