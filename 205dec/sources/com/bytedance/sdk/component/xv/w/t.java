package com.bytedance.sdk.component.xv.w;

import com.bytedance.sdk.component.xv.w.gb;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class t {
    private String sr;
    private ExecutorService ux;
    private Runnable xv;

    /* renamed from: c  reason: collision with root package name */
    private int f31110c = 64;

    /* renamed from: w  reason: collision with root package name */
    private int f31113w = 5;

    /* renamed from: f  reason: collision with root package name */
    private final Deque<gb.c> f31111f = new ArrayDeque();

    /* renamed from: r  reason: collision with root package name */
    private final Deque<gb.c> f31112r = new ArrayDeque();
    private final Deque<gb> ev = new ArrayDeque();

    public t() {
    }

    private void xv() {
        if (this.f31112r.size() < this.f31110c && !this.f31111f.isEmpty()) {
            Iterator<gb.c> it = this.f31111f.iterator();
            while (it.hasNext()) {
                gb.c next = it.next();
                if (xv(next) < this.f31113w) {
                    it.remove();
                    this.f31112r.add(next);
                    if (next != null) {
                        next.w();
                    }
                    c().execute(next);
                }
                if (this.f31112r.size() >= this.f31110c) {
                    return;
                }
            }
        }
    }

    public synchronized ExecutorService c() {
        String str;
        if (this.ux == null) {
            String str2 = this.sr;
            if (str2 != null && str2.length() != 0) {
                str = this.sr;
                this.ux = new com.bytedance.sdk.component.gd.sr.sr(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.xv.w.c.xv.c(str, false));
            }
            str = "net";
            this.ux = new com.bytedance.sdk.component.gd.sr.sr(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.xv.w.c.xv.c(str, false));
        }
        return this.ux;
    }

    public synchronized void w(int i4) {
        if (i4 >= 1) {
            this.f31113w = i4;
            xv();
        } else {
            throw new IllegalArgumentException("max < 1: " + i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(gb.c cVar) {
        c(this.f31112r, cVar, true);
    }

    public synchronized void c(int i4) {
        if (i4 >= 1) {
            this.f31110c = i4;
            xv();
        } else {
            throw new IllegalArgumentException("max < 1: " + i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(gb gbVar) {
        c(this.ev, gbVar, false);
    }

    public t(String str) {
        this.sr = str;
    }

    public synchronized int w() {
        return this.f31112r.size() + this.ev.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(gb.c cVar) {
        try {
            if (this.f31112r.size() < this.f31110c && xv(cVar) < this.f31113w) {
                this.f31112r.add(cVar);
                if (cVar != null) {
                    cVar.w();
                }
                c().execute(cVar);
            } else {
                this.f31111f.add(cVar);
            }
        } catch (Throwable unused) {
        }
    }

    private int xv(gb.c cVar) {
        int i4 = 0;
        for (gb.c cVar2 : this.f31112r) {
            if (cVar2.c().equals(cVar.c())) {
                i4++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(gb gbVar) {
        this.ev.add(gbVar);
    }

    private <T> void c(Deque<T> deque, T t3, boolean z3) {
        int w3;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t3)) {
                if (z3) {
                    xv();
                }
                w3 = w();
                runnable = this.xv;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (w3 != 0 || runnable == null) {
            return;
        }
        runnable.run();
    }
}
