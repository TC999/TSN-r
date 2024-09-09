package com.bytedance.sdk.component.gd.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    final Runnable f29881c;

    public xv(Runnable runnable) {
        this.f29881c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f29881c.run();
    }
}
