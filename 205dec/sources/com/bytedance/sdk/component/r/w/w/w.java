package com.bytedance.sdk.component.r.w.w;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.r.c.gd;
import com.bytedance.sdk.component.r.c.sr;
import com.bytedance.sdk.component.r.c.ux;
import com.bytedance.sdk.component.r.w.w.xv.xv;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements gd {

    /* renamed from: c  reason: collision with root package name */
    public static final com.bytedance.sdk.component.r.w.w.c.c f30136c = new com.bytedance.sdk.component.r.w.w.c.c();
    public static final long sr = System.currentTimeMillis();
    public static long ux = 0;
    private ux ev;

    /* renamed from: f  reason: collision with root package name */
    private volatile xv f30137f;
    private final Comparator<com.bytedance.sdk.component.r.c.w> gd;

    /* renamed from: p  reason: collision with root package name */
    private final PriorityBlockingQueue<com.bytedance.sdk.component.r.c.w> f30138p;

    /* renamed from: r  reason: collision with root package name */
    private volatile Handler f30139r;

    /* renamed from: w  reason: collision with root package name */
    public volatile boolean f30140w = false;
    public volatile boolean xv = false;

    public w(ux uxVar) {
        Comparator<com.bytedance.sdk.component.r.c.w> comparator = new Comparator<com.bytedance.sdk.component.r.c.w>() { // from class: com.bytedance.sdk.component.r.w.w.w.1
            @Override // java.util.Comparator
            /* renamed from: c */
            public int compare(com.bytedance.sdk.component.r.c.w wVar, com.bytedance.sdk.component.r.c.w wVar2) {
                return w.this.c(wVar, wVar2);
            }
        };
        this.gd = comparator;
        this.f30138p = new PriorityBlockingQueue<>(8, comparator);
        this.ev = uxVar;
    }

    public PriorityBlockingQueue<com.bytedance.sdk.component.r.c.w> sr() {
        return this.f30138p;
    }

    public xv ux() {
        return this.f30137f;
    }

    @Override // com.bytedance.sdk.component.r.c.gd
    public void w() {
        if (this.f30137f == null || !this.f30137f.isAlive()) {
            return;
        }
        synchronized (this) {
            if (this.f30137f != null && this.f30137f.isAlive()) {
                if (this.f30139r != null) {
                    this.f30139r.removeCallbacksAndMessages(null);
                }
                this.f30137f.c(false);
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f30137f.quitSafely();
                } else {
                    this.f30137f.quit();
                }
                this.f30137f = null;
            }
        }
    }

    @Override // com.bytedance.sdk.component.r.c.gd
    public void xv() {
        com.bytedance.sdk.component.r.w.xv.xv.xv("flushMemoryAndDB", this.ev);
        ux uxVar = this.ev;
        if (uxVar == null) {
            com.bytedance.sdk.component.r.w.xv.xv.xv("discard flush config is null", uxVar);
            return;
        }
        sr sr2 = uxVar.sr();
        if (sr2 == null) {
            com.bytedance.sdk.component.r.w.xv.xv.xv("discard flush logDepend is null", this.ev);
            return;
        }
        final xv xvVar = this.f30137f;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (xvVar != null) {
                xvVar.c(2, "start_child2");
                return;
            }
            return;
        }
        ux uxVar2 = this.ev;
        if (uxVar2 != null) {
            Executor ev = sr2.ev();
            if (ev == null) {
                ev = sr2.gd();
            }
            if (ev != null) {
                ev.execute(new com.bytedance.sdk.component.r.w.ux.w("flush") { // from class: com.bytedance.sdk.component.r.w.w.w.3
                    @Override // java.lang.Runnable
                    public void run() {
                        xv xvVar2 = xvVar;
                        if (xvVar2 != null) {
                            xvVar2.c(2, "start_child1");
                        }
                    }
                });
                return;
            } else {
                com.bytedance.sdk.component.r.w.xv.xv.xv("discard flush executor is null", this.ev);
                return;
            }
        }
        com.bytedance.sdk.component.r.w.xv.xv.xv("discard flush", uxVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(com.bytedance.sdk.component.r.c.w wVar, com.bytedance.sdk.component.r.c.w wVar2) {
        long j4;
        long j5;
        long j6;
        long j7;
        if (wVar == null) {
            return wVar2 == null ? 0 : -1;
        } else if (wVar2 == null) {
            return 1;
        } else {
            if (wVar.ux() == wVar2.ux()) {
                if (wVar.c() != null) {
                    j4 = wVar.c().c();
                    j5 = wVar.c().w();
                } else {
                    j4 = 0;
                    j5 = 0;
                }
                if (wVar2.c() != null) {
                    j7 = wVar2.c().c();
                    j6 = wVar2.c().w();
                } else {
                    j6 = 0;
                    j7 = 0;
                }
                if (j4 == 0 || j7 == 0) {
                    return 0;
                }
                long j8 = j4 - j7;
                if (Math.abs(j8) > 2147483647L) {
                    return 0;
                }
                if (j8 == 0) {
                    if (j5 == 0 || j6 == 0) {
                        return 0;
                    }
                    return (int) (j5 - j6);
                }
                return (int) j8;
            }
            return wVar.ux() - wVar2.ux();
        }
    }

    @Override // com.bytedance.sdk.component.r.c.gd
    public void c() {
        ux uxVar = this.ev;
        if (uxVar == null) {
            return;
        }
        c(uxVar.ux());
        xv();
    }

    public void c(Handler handler) {
        this.f30139r = handler;
    }

    public boolean c(String str) {
        try {
            if (this.f30137f != null || com.bytedance.sdk.component.r.w.c.c(str) || this.ev == null) {
                return false;
            }
            synchronized (this) {
                if (this.f30137f == null) {
                    com.bytedance.sdk.component.r.w.xv.xv.c("--start LogThread--", this.ev);
                    this.f30137f = new xv(this.f30138p, this.ev, this);
                    this.f30137f.start();
                    return true;
                }
                return false;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.r.w.xv.xv.sr(th.getMessage(), this.ev);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.r.c.gd
    public void c(com.bytedance.sdk.component.r.c.w wVar) {
        ux uxVar;
        if (wVar != null && (uxVar = this.ev) != null) {
            String ux2 = uxVar.ux();
            wVar.c(System.currentTimeMillis());
            wVar.sr();
            c(ux2);
            sr sr2 = this.ev.sr();
            xv xvVar = this.f30137f;
            if (xvVar != null) {
                c(sr2, wVar);
                xvVar.c(wVar, wVar.ux() == 4);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.r.w.xv.xv.ux("error : log config is null", this.ev);
    }

    private void c(final sr srVar, com.bytedance.sdk.component.r.c.w wVar) {
        if (srVar != null) {
            try {
                if (srVar.xv()) {
                    long j4 = 0;
                    if (wVar != null && wVar.c() != null) {
                        j4 = wVar.c().w();
                    }
                    final long j5 = j4;
                    if (j5 == 1) {
                        ux = System.currentTimeMillis();
                    }
                    AtomicLong i4 = f30136c.i();
                    com.bytedance.sdk.component.r.w.xv.w.c(i4, 1, this.ev);
                    if (i4.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            Executor ev = srVar.ev();
                            if (ev == null) {
                                ev = srVar.gd();
                            }
                            if (ev != null) {
                                ev.execute(new com.bytedance.sdk.component.r.w.ux.w("report") { // from class: com.bytedance.sdk.component.r.w.w.w.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        w.this.c(srVar, j5);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        com.bytedance.sdk.component.r.w.xv.xv.c("==> monitor upload index1:" + j5, this.ev);
                        c(srVar, j5);
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(sr srVar, long j4) {
        xv xvVar = this.f30137f;
        if (srVar == null || xvVar == null) {
            return;
        }
        com.bytedance.sdk.component.r.w.w.c.c cVar = f30136c;
        xvVar.c(srVar.c(cVar.c(j4, this.ev)), true);
        cVar.p();
    }
}
