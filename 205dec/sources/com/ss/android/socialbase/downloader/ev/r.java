package com.ss.android.socialbase.downloader.ev;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class r {
    private Handler sr;
    private c xv;

    /* renamed from: c  reason: collision with root package name */
    private Object f49537c = new Object();

    /* renamed from: w  reason: collision with root package name */
    private Queue<w> f49538w = new ConcurrentLinkedQueue();

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private class c extends HandlerThread {
        c(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (r.this.f49537c) {
                r.this.sr = new Handler(looper);
            }
            while (!r.this.f49538w.isEmpty()) {
                w wVar = (w) r.this.f49538w.poll();
                if (wVar != null) {
                    r.this.sr.postDelayed(wVar.f49540c, wVar.f49541w);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public class w {

        /* renamed from: c  reason: collision with root package name */
        public Runnable f49540c;

        /* renamed from: w  reason: collision with root package name */
        public long f49541w;

        public w(Runnable runnable, long j4) {
            this.f49540c = runnable;
            this.f49541w = j4;
        }
    }

    public r(String str) {
        this.xv = new c(str);
    }

    public void w() {
        this.xv.quit();
    }

    public void c() {
        this.xv.start();
    }

    public void c(Runnable runnable) {
        c(runnable, 0L);
    }

    public void c(Runnable runnable, long j4) {
        if (this.sr == null) {
            synchronized (this.f49537c) {
                if (this.sr == null) {
                    this.f49538w.add(new w(runnable, j4));
                    return;
                }
            }
        }
        this.sr.postDelayed(runnable, j4);
    }
}
