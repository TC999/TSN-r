package com.bytedance.sdk.component.xv.w;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.xv.w.c.w.r;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class p {
    private static final Executor sr = new com.bytedance.sdk.component.gd.sr.sr(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.xv.w.c.xv.c("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean xv = true;

    /* renamed from: c  reason: collision with root package name */
    final com.bytedance.sdk.component.xv.w.c.w.sr f31074c;
    private long ev;

    /* renamed from: f  reason: collision with root package name */
    private long f31075f;
    private final Runnable gd;

    /* renamed from: p  reason: collision with root package name */
    private final Deque<com.bytedance.sdk.component.xv.w.c.w.xv> f31076p;

    /* renamed from: r  reason: collision with root package name */
    private List<String> f31077r;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    boolean f31078w;

    public p() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    private boolean xv(com.bytedance.sdk.component.xv.w.c.w.xv xvVar) {
        try {
            List<String> list = this.f31077r;
            if (list != null && !list.isEmpty() && xvVar.c() != null && xvVar.c().c() != null && xvVar.c().c().c() != null && xvVar.c().c().c().r() != null) {
                String r3 = xvVar.c().c().c().r();
                if (!TextUtils.isEmpty(r3)) {
                    if (this.f31077r.contains(r3)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public void c(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i4 = bundle.getInt("max_idle_cnt");
                    if (i4 <= 5) {
                        i4 = this.ux;
                    }
                    this.ux = i4;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j4 = bundle.getLong("max_idle_time");
                    this.f31075f = j4 > 5 ? TimeUnit.MINUTES.toNanos(j4) : this.f31075f;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.f31077r = bundle.getStringArrayList("white_hosts");
                    long j5 = bundle.getLong("white_extra_idle_time");
                    this.ev = j5 > 0 ? TimeUnit.MINUTES.toNanos(j5) : 0L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w(com.bytedance.sdk.component.xv.w.c.w.xv xvVar) {
        if (xv || Thread.holdsLock(this)) {
            if (!xvVar.f30933c && this.ux != 0) {
                notifyAll();
                return false;
            }
            this.f31076p.remove(xvVar);
            return true;
        }
        throw new AssertionError();
    }

    public p(int i4, long j4, TimeUnit timeUnit) {
        this.gd = new Runnable() { // from class: com.bytedance.sdk.component.xv.w.p.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long c4 = p.this.c(System.nanoTime());
                    if (c4 == -1) {
                        return;
                    }
                    if (c4 > 0) {
                        long j5 = c4 / C.MICROS_PER_SECOND;
                        long j6 = c4 - (C.MICROS_PER_SECOND * j5);
                        synchronized (p.this) {
                            try {
                                p.this.wait(j5, (int) j6);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.f31076p = new ArrayDeque();
        this.f31074c = new com.bytedance.sdk.component.xv.w.c.w.sr();
        this.ux = i4;
        this.f31075f = timeUnit.toNanos(j4);
        if (j4 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.sdk.component.xv.w.c.w.xv c(c cVar, com.bytedance.sdk.component.xv.w.c.w.r rVar, eq eqVar) {
        if (xv || Thread.holdsLock(this)) {
            for (com.bytedance.sdk.component.xv.w.c.w.xv xvVar : this.f31076p) {
                if (xvVar.c(cVar, eqVar)) {
                    if (rVar != null) {
                        rVar.c(xvVar, true);
                    }
                    return xvVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Socket c(c cVar, com.bytedance.sdk.component.xv.w.c.w.r rVar) {
        if (xv || Thread.holdsLock(this)) {
            for (com.bytedance.sdk.component.xv.w.c.w.xv xvVar : this.f31076p) {
                if (xvVar.c(cVar, null) && xvVar.ux() && xvVar != rVar.w()) {
                    return rVar.c(xvVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bytedance.sdk.component.xv.w.c.w.xv xvVar) {
        if (!xv && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f31078w) {
            this.f31078w = true;
            sr.execute(this.gd);
        }
        this.f31076p.add(xvVar);
    }

    long c(long j4) {
        try {
            synchronized (this) {
                com.bytedance.sdk.component.xv.w.c.w.xv xvVar = null;
                long j5 = Long.MIN_VALUE;
                int i4 = 0;
                int i5 = 0;
                for (com.bytedance.sdk.component.xv.w.c.w.xv xvVar2 : this.f31076p) {
                    if (c(xvVar2, j4) > 0) {
                        i5++;
                    } else {
                        i4++;
                        long j6 = j4 - xvVar2.ux;
                        com.bytedance.sdk.component.xv.w.c.w.xv xvVar3 = xvVar;
                        if (this.ev > 0 && xv(xvVar2)) {
                            j6 -= this.ev;
                        }
                        if (j6 > j5) {
                            xvVar = xvVar2;
                            j5 = j6;
                        } else {
                            xvVar = xvVar3;
                        }
                    }
                }
                com.bytedance.sdk.component.xv.w.c.w.xv xvVar4 = xvVar;
                long j7 = this.f31075f;
                if (j5 < j7 && i4 <= this.ux) {
                    if (i4 > 0) {
                        return j7 - j5;
                    } else if (i5 > 0) {
                        return j7;
                    } else {
                        this.f31078w = false;
                        Log.i("ConnectionPool", "cleanup: ");
                        return -1L;
                    }
                }
                this.f31076p.remove(xvVar4);
                com.bytedance.sdk.component.xv.w.c.xv.c(xvVar4.xv());
                return 0L;
            }
        } catch (OutOfMemoryError unused) {
            return this.f31075f;
        }
    }

    private int c(com.bytedance.sdk.component.xv.w.c.w.xv xvVar, long j4) {
        List<Reference<com.bytedance.sdk.component.xv.w.c.w.r>> list = xvVar.sr;
        int i4 = 0;
        while (i4 < list.size()) {
            Reference<com.bytedance.sdk.component.xv.w.c.w.r> reference = list.get(i4);
            if (reference.get() != null) {
                i4++;
            } else {
                com.bytedance.sdk.component.xv.w.c.r.ux.w().c("A connection to " + xvVar.c().c().c() + " was leaked. Did you forget to close a response body?", ((r.c) reference).f30926c);
                list.remove(i4);
                xvVar.f30933c = true;
                if (list.isEmpty()) {
                    xvVar.ux = j4 - this.f31075f;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
