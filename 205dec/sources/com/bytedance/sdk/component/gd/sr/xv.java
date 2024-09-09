package com.bytedance.sdk.component.gd.sr;

import com.bytedance.sdk.component.gd.a;
import com.bytedance.sdk.component.gd.c.r;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends Thread {
    private r proxy;

    public xv() {
    }

    @Override // java.lang.Thread
    public void interrupt() {
        r rVar = this.proxy;
        if (rVar != null) {
            rVar.interrupt();
        } else {
            super.interrupt();
        }
    }

    @Override // java.lang.Thread
    public boolean isInterrupted() {
        r rVar = this.proxy;
        return rVar != null ? rVar.isInterrupted() : super.isInterrupted();
    }

    protected boolean isProxyEnable() {
        return a.f29806w.c(1);
    }

    @Override // java.lang.Thread
    public synchronized void start() {
        try {
            if (isProxyEnable()) {
                if (this.proxy == null) {
                    this.proxy = new r(this);
                }
                this.proxy.start();
            } else {
                super.start();
            }
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.gd.ux.f29863c.c("PThread");
            a aVar = a.f29806w;
            aVar.k().schedule(new Runnable() { // from class: com.bytedance.sdk.component.gd.sr.xv.1
                @Override // java.lang.Runnable
                public void run() {
                    xv.super.start();
                }
            }, aVar.sr(), TimeUnit.MILLISECONDS);
        }
    }

    public xv(Runnable runnable) {
        super(runnable);
    }

    public xv(String str) {
        super(str);
    }

    public xv(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
    }

    public xv(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }

    public xv(Runnable runnable, String str) {
        super(runnable, str);
    }

    public xv(ThreadGroup threadGroup, Runnable runnable, String str) {
        super(threadGroup, runnable, str);
    }

    public xv(ThreadGroup threadGroup, Runnable runnable, String str, long j4) {
        super(threadGroup, runnable, str, j4);
    }
}
