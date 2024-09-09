package com.qq.e.comm.plugin.fs;

import com.qq.e.comm.plugin.g0.e;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o0.h.f;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class b implements com.qq.e.comm.plugin.fs.a {

    /* renamed from: d  reason: collision with root package name */
    private static final String f43170d = "b";

    /* renamed from: a  reason: collision with root package name */
    private final c f43171a;

    /* renamed from: b  reason: collision with root package name */
    private final e f43172b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledFuture<?> f43173c;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f c4;
            com.qq.e.comm.plugin.fs.f.a b4 = b.this.f43171a.b();
            if (b4 == null || (c4 = b4.c()) == null || !c4.isPlaying()) {
                return;
            }
            d1.a(b.f43170d, "\u89c6\u9891\u5c1d\u8bd5\u5728\u540e\u53f0\u5f00\u59cb\u64ad\u653e\u4e86\uff0c\u7acb\u5373\u6682\u505c");
            c4.pause();
            v.a(9411113, com.qq.e.comm.plugin.n0.c.a(b.this.f43172b));
            if (b.this.f43173c == null || b.this.f43173c.isCancelled()) {
                return;
            }
            b.this.f43173c.cancel(false);
        }
    }

    public b(c cVar, e eVar) {
        this.f43171a = cVar;
        this.f43172b = eVar;
    }

    @Override // com.qq.e.comm.plugin.fs.a
    public void onDestroy() {
        ScheduledFuture<?> scheduledFuture = this.f43173c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    @Override // com.qq.e.comm.plugin.fs.a
    public void onPause() {
        ScheduledFuture<?> scheduledFuture = this.f43173c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        this.f43173c = d0.f46410f.scheduleAtFixedRate(new a(), 200L, 200L, TimeUnit.MILLISECONDS);
    }

    @Override // com.qq.e.comm.plugin.fs.a
    public void onResume() {
        ScheduledFuture<?> scheduledFuture = this.f43173c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }
}
