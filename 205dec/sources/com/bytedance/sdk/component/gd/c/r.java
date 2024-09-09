package com.bytedance.sdk.component.gd.c;

import com.bytedance.sdk.component.gd.a;
import com.bytedance.sdk.component.gd.p;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class r extends Thread {

    /* renamed from: c  reason: collision with root package name */
    private volatile Thread f29831c;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f29832w;
    private final Thread xv;

    public r(Thread thread) {
        this.xv = thread;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        if (this.f29831c != null) {
            this.f29831c.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        if (this.f29831c != null) {
            return this.f29831c.isInterrupted();
        }
        return true;
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        if (this.f29832w) {
            return;
        }
        this.f29832w = true;
        a.f29806w.p().execute(new com.bytedance.sdk.component.gd.xv.xv(new p(this.xv.getName()) { // from class: com.bytedance.sdk.component.gd.c.r.1
            @Override // java.lang.Runnable
            public void run() {
                r.this.c();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        try {
            w xv = a.f29806w.xv();
            String name2 = this.xv.getName();
            if (xv != null) {
                name2 = xv.c(name2);
            }
            currentThread.setName(name2);
            this.f29831c = currentThread;
            currentThread.setPriority(this.xv.getPriority());
            this.xv.run();
        } finally {
            currentThread.setName(name);
        }
    }
}
