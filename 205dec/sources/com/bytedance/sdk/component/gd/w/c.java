package com.bytedance.sdk.component.gd.w;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.n;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final sr<w> f29870c;

    /* renamed from: w  reason: collision with root package name */
    private Handler f29871w;

    /* renamed from: com.bytedance.sdk.component.gd.w.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class C0447c {

        /* renamed from: c  reason: collision with root package name */
        private static final c f29876c = new c();
    }

    public Handler w() {
        if (this.f29871w == null) {
            synchronized (c.class) {
                if (this.f29871w == null) {
                    this.f29871w = c("csj_io_handler");
                }
            }
        }
        return this.f29871w;
    }

    private c() {
        this.f29870c = sr.c(2);
    }

    public static c c() {
        return C0447c.f29876c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Handler handler, final Handler handler2) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (handler.getLooper().getQueue().isIdle()) {
                handler.removeCallbacksAndMessages(null);
                handler.getLooper().quit();
                return;
            }
            handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.gd.w.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c(handler, handler2);
                }
            }, 1000L);
        }
    }

    private w w(n.c cVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new w(handlerThread, cVar);
    }

    public n c(n.c cVar, final String str) {
        w c4 = this.f29870c.c();
        if (c4 != null) {
            c4.c(cVar);
            c4.post(new Runnable() { // from class: com.bytedance.sdk.component.gd.w.c.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return c4;
        }
        return w(cVar, str);
    }

    public n c(String str) {
        return c((n.c) null, str);
    }

    public boolean c(n nVar) {
        if (nVar instanceof w) {
            w wVar = (w) nVar;
            if (this.f29870c.c((sr<w>) wVar)) {
                return true;
            }
            wVar.w();
            return true;
        }
        return false;
    }
}
