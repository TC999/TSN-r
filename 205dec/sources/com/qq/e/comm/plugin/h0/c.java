package com.qq.e.comm.plugin.h0;

import android.app.Activity;
import android.view.Choreographer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c extends a implements Choreographer.FrameCallback {

    /* renamed from: m  reason: collision with root package name */
    private static final String f44014m = c.class.getSimpleName();

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f44015i;

    /* renamed from: j  reason: collision with root package name */
    private final Choreographer f44016j;

    /* renamed from: k  reason: collision with root package name */
    private long f44017k;

    /* renamed from: l  reason: collision with root package name */
    private ScheduledExecutorService f44018l;

    public c(Activity activity, long j4) {
        super(activity, j4);
        this.f44015i = new AtomicInteger();
        this.f44016j = Choreographer.getInstance();
    }

    private void d() {
    }

    @Override // com.qq.e.comm.plugin.h0.a
    String b() {
        return f44014m;
    }

    @Override // com.qq.e.comm.plugin.h0.a
    protected void c() {
        ScheduledExecutorService scheduledExecutorService = this.f44018l;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
        this.f44015i.set(0);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j4) {
        if (this.f44005h.get()) {
            if (this.f44017k == 0) {
                this.f44017k = j4;
            }
            a((int) ((j4 - this.f44017k) / this.f43999b));
            this.f44017k = j4;
            this.f44015i.getAndIncrement();
            this.f44016j.postFrameCallback(this);
        }
    }

    @Override // com.qq.e.comm.plugin.h0.a, com.qq.e.comm.plugin.h0.f
    public void start() {
        super.start();
        d();
        this.f44016j.postFrameCallback(this);
    }
}
