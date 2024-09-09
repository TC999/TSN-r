package com.qq.e.comm.plugin.h0;

import android.os.Looper;
import android.os.SystemClock;
import com.qq.e.comm.plugin.h0.g;
import com.qq.e.comm.plugin.util.d0;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b implements Runnable, g.d {

    /* renamed from: e  reason: collision with root package name */
    private boolean f44008e;

    /* renamed from: h  reason: collision with root package name */
    private volatile long f44011h;

    /* renamed from: i  reason: collision with root package name */
    private volatile long f44012i;

    /* renamed from: j  reason: collision with root package name */
    private ScheduledFuture<?> f44013j;

    /* renamed from: f  reason: collision with root package name */
    private int f44009f = 700;

    /* renamed from: g  reason: collision with root package name */
    private int f44010g = 100;

    /* renamed from: c  reason: collision with root package name */
    private final g f44006c = g.a(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private final j f44007d = new j();

    public b a(int i4, int i5) {
        this.f44009f = i4;
        this.f44010g = i5;
        return this;
    }

    @Override // com.qq.e.comm.plugin.h0.g.d
    public void b() {
        if (this.f44008e) {
            return;
        }
        this.f44011h = SystemClock.uptimeMillis();
        this.f44008e = true;
    }

    public void c() {
        this.f44006c.a(this);
        ScheduledExecutorService scheduledExecutorService = d0.f46410f;
        long j4 = this.f44010g;
        this.f44013j = scheduledExecutorService.scheduleWithFixedDelay(this, j4, j4, TimeUnit.MILLISECONDS);
    }

    public void d() {
        this.f44006c.b(this);
        this.f44006c.a();
        ScheduledFuture<?> scheduledFuture = this.f44013j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        long j4 = this.f44011h;
        if (j4 <= 0 || SystemClock.uptimeMillis() - j4 < this.f44009f) {
            return;
        }
        if (this.f44012i != j4) {
            this.f44007d.a(Looper.getMainLooper().getThread());
        }
        this.f44012i = j4;
    }

    public b a(boolean z3) {
        this.f44007d.a(z3);
        return this;
    }

    @Override // com.qq.e.comm.plugin.h0.g.d
    public void a() {
        if (this.f44008e) {
            this.f44011h = 0L;
            this.f44008e = false;
        }
    }
}
