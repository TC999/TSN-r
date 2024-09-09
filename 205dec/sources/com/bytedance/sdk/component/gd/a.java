package com.bytedance.sdk.component.gd;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final int f29805c = ev.f29838c;

    /* renamed from: w  reason: collision with root package name */
    public static final a f29806w = new a();
    private com.bytedance.sdk.component.gd.c.ux bk;
    private volatile ScheduledExecutorService fp;
    private volatile boolean gd;

    /* renamed from: i  reason: collision with root package name */
    private xv f29809i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f29810j;

    /* renamed from: q  reason: collision with root package name */
    private boolean f29813q;

    /* renamed from: s  reason: collision with root package name */
    private int f29815s;

    /* renamed from: t  reason: collision with root package name */
    private volatile ThreadPoolExecutor f29816t;

    /* renamed from: u  reason: collision with root package name */
    private com.bytedance.sdk.component.gd.c.w f29817u;
    private volatile ThreadPoolExecutor ys;
    public volatile boolean xv = true;

    /* renamed from: f  reason: collision with root package name */
    private long f29808f = 5000;

    /* renamed from: r  reason: collision with root package name */
    private long f29814r = 20000;
    private volatile boolean ev = true;

    /* renamed from: p  reason: collision with root package name */
    private boolean f29812p = true;

    /* renamed from: k  reason: collision with root package name */
    private long f29811k = 100;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f29807a = true;
    private boolean ia = true;
    private boolean fz = true;
    private int sr = Math.min(f29805c, 4);
    private int ux = 50;

    private a() {
    }

    public ThreadPoolExecutor a() {
        if (this.gd) {
            return p();
        }
        return gd();
    }

    public xv bk() {
        return this.f29809i;
    }

    public int ev() {
        return this.sr;
    }

    public boolean f() {
        return this.f29813q;
    }

    public ThreadPoolExecutor gd() {
        if (this.f29816t == null) {
            synchronized (this) {
                if (this.f29816t == null) {
                    this.f29816t = new com.bytedance.sdk.component.gd.xv.sr(this.sr, this.ux, this.f29814r, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new k(10, "l") { // from class: com.bytedance.sdk.component.gd.a.1
                        @Override // com.bytedance.sdk.component.gd.k
                        protected Thread c(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                }
            }
        }
        return this.f29816t;
    }

    public ScheduledExecutorService k() {
        if (this.fp == null) {
            synchronized (this) {
                if (this.fp == null) {
                    this.fp = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.bytedance.sdk.component.gd.a.3
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, a.this.f29813q ? "csj-p-wp" : "csj-wp");
                        }
                    }, com.bytedance.sdk.component.gd.sr.c.f29848c);
                }
            }
        }
        return this.fp;
    }

    public ThreadPoolExecutor p() {
        if (this.ys == null) {
            synchronized (this) {
                if (this.ys == null) {
                    this.ys = new com.bytedance.sdk.component.gd.xv.w(this.sr, this.ux, this.f29808f, TimeUnit.MILLISECONDS, new k(10, "b") { // from class: com.bytedance.sdk.component.gd.a.2
                        @Override // com.bytedance.sdk.component.gd.k
                        protected Thread c(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                }
            }
        }
        return this.ys;
    }

    public com.bytedance.sdk.component.gd.c.ux r() {
        if (this.bk == null) {
            this.bk = new com.bytedance.sdk.component.gd.c.ux();
        }
        return this.bk;
    }

    public long sr() {
        return this.f29811k;
    }

    public boolean t() {
        return this.f29810j;
    }

    public boolean ux() {
        return this.xv;
    }

    public boolean w() {
        return this.ia;
    }

    public com.bytedance.sdk.component.gd.c.w xv() {
        return this.f29817u;
    }

    public boolean c(int i4) {
        return (this.f29815s & i4) == i4;
    }

    public void sr(boolean z3) {
        this.ev = z3;
    }

    public void ux(boolean z3) {
        this.f29810j = z3;
    }

    public void w(boolean z3) {
        this.xv = z3;
    }

    public void xv(int i4) {
        gd().setMaximumPoolSize(i4);
        p().setMaximumPoolSize(i4);
    }

    public boolean c() {
        return this.f29812p;
    }

    public void w(int i4) {
        this.sr = i4;
        gd().setCorePoolSize(i4);
        p().setCorePoolSize(i4);
    }

    public void c(boolean z3) {
        this.ia = z3;
    }

    public void xv(boolean z3) {
        this.gd = z3;
    }

    public void c(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.ys;
        this.ys = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        f.c(threadPoolExecutor, threadPoolExecutor2);
    }

    public void w(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.f29816t;
        this.f29816t = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        ((com.bytedance.sdk.component.gd.xv.sr) threadPoolExecutor2).w();
        f.c(threadPoolExecutor, threadPoolExecutor2);
    }

    public void c(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            return;
        }
        final ScheduledExecutorService scheduledExecutorService2 = this.fp;
        this.fp = scheduledExecutorService;
        if (scheduledExecutorService2 == null || scheduledExecutorService2 == scheduledExecutorService) {
            return;
        }
        this.fp.schedule(new Runnable() { // from class: com.bytedance.sdk.component.gd.a.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    scheduledExecutorService2.shutdown();
                } catch (Exception e4) {
                    com.bytedance.sdk.component.utils.a.sr("ThreadCenter", e4);
                }
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }

    public void c(long j4) {
        this.f29808f = j4;
        p().setKeepAliveTime(j4, TimeUnit.MILLISECONDS);
    }
}
