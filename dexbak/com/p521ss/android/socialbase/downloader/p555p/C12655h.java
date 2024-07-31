package com.p521ss.android.socialbase.downloader.p555p;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.ss.android.socialbase.downloader.p.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12655h {

    /* renamed from: bl */
    private HandlerThreadC12657ok f35716bl;

    /* renamed from: s */
    private Handler f35718s;

    /* renamed from: ok */
    private Object f35717ok = new Object();

    /* renamed from: a */
    private Queue<C12656a> f35715a = new ConcurrentLinkedQueue();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.downloader.p.h$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12656a {

        /* renamed from: a */
        public long f35719a;

        /* renamed from: ok */
        public Runnable f35721ok;

        public C12656a(Runnable runnable, long j) {
            this.f35721ok = runnable;
            this.f35719a = j;
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.p.h$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class HandlerThreadC12657ok extends HandlerThread {
        HandlerThreadC12657ok(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (C12655h.this.f35717ok) {
                C12655h.this.f35718s = new Handler(looper);
            }
            while (!C12655h.this.f35715a.isEmpty()) {
                C12656a c12656a = (C12656a) C12655h.this.f35715a.poll();
                if (c12656a != null) {
                    C12655h.this.f35718s.postDelayed(c12656a.f35721ok, c12656a.f35719a);
                }
            }
        }
    }

    public C12655h(String str) {
        this.f35716bl = new HandlerThreadC12657ok(str);
    }

    /* renamed from: a */
    public void m16769a() {
        this.f35716bl.quit();
    }

    /* renamed from: ok */
    public void m16766ok() {
        this.f35716bl.start();
    }

    /* renamed from: ok */
    public void m16763ok(Runnable runnable) {
        m16762ok(runnable, 0L);
    }

    /* renamed from: ok */
    public void m16762ok(Runnable runnable, long j) {
        if (this.f35718s == null) {
            synchronized (this.f35717ok) {
                if (this.f35718s == null) {
                    this.f35715a.add(new C12656a(runnable, j));
                    return;
                }
            }
        }
        this.f35718s.postDelayed(runnable, j);
    }
}
