package com.bytedance.sdk.component.w.c.c.w;

import com.bytedance.sdk.component.w.c.c.w.c;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends com.bytedance.sdk.component.w.c.sr {

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f30398c;

    /* renamed from: w  reason: collision with root package name */
    private final Deque<c.C0456c> f30399w = new ArrayDeque();
    private final Deque<c.C0456c> xv = new ArrayDeque();
    private final Deque<c> sr = new ArrayDeque();
    private AtomicInteger ux = new AtomicInteger(64);

    public sr() {
        if (this.f30398c == null) {
            this.f30398c = new com.bytedance.sdk.component.gd.sr.sr(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.component.w.c.c.w.sr.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.gd.sr.xv xvVar = new com.bytedance.sdk.component.gd.sr.xv(runnable, "systemHttp Dispatcher");
                    xvVar.setDaemon(false);
                    xvVar.setPriority(10);
                    return xvVar;
                }
            });
        }
    }

    private void xv() {
        if (this.xv.size() < c() && !this.f30399w.isEmpty()) {
            Iterator<c.C0456c> it = this.f30399w.iterator();
            while (it.hasNext()) {
                c.C0456c next = it.next();
                it.remove();
                this.xv.add(next);
                if (next != null) {
                    next.c();
                }
                w().submit(next);
                if (this.xv.size() >= c()) {
                    return;
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.w.c.sr
    public void c(int i4) {
        this.ux.set(i4);
    }

    @Override // com.bytedance.sdk.component.w.c.sr
    public ExecutorService w() {
        return this.f30398c;
    }

    @Override // com.bytedance.sdk.component.w.c.sr
    public void w(int i4) {
    }

    @Override // com.bytedance.sdk.component.w.c.sr
    public int c() {
        return this.ux.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(c.C0456c c0456c) {
        c(this.xv, c0456c, true);
    }

    public synchronized void c(c.C0456c c0456c) {
        try {
            if (this.xv.size() < c()) {
                this.xv.add(c0456c);
                if (c0456c != null) {
                    c0456c.c();
                }
                w().submit(c0456c);
            } else {
                this.f30399w.add(c0456c);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(c cVar) {
        c(this.sr, cVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void c(c cVar) {
        this.sr.add(cVar);
    }

    private <T> void c(Deque<T> deque, T t3, boolean z3) {
        synchronized (this) {
            deque.remove(t3);
            if (z3) {
                xv();
            }
        }
    }
}
