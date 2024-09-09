package com.ss.android.socialbase.downloader.p;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {
    private ok bl;

    /* renamed from: s  reason: collision with root package name */
    private Handler f50138s;
    private Object ok = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Queue<a> f50137a = new ConcurrentLinkedQueue();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f50139a;
        public Runnable ok;

        public a(Runnable runnable, long j4) {
            this.ok = runnable;
            this.f50139a = j4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class ok extends HandlerThread {
        ok(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (h.this.ok) {
                h.this.f50138s = new Handler(looper);
            }
            while (!h.this.f50137a.isEmpty()) {
                a aVar = (a) h.this.f50137a.poll();
                if (aVar != null) {
                    h.this.f50138s.postDelayed(aVar.ok, aVar.f50139a);
                }
            }
        }
    }

    public h(String str) {
        this.bl = new ok(str);
    }

    public void a() {
        this.bl.quit();
    }

    public void ok() {
        this.bl.start();
    }

    public void ok(Runnable runnable) {
        ok(runnable, 0L);
    }

    public void ok(Runnable runnable, long j4) {
        if (this.f50138s == null) {
            synchronized (this.ok) {
                if (this.f50138s == null) {
                    this.f50137a.add(new a(runnable, j4));
                    return;
                }
            }
        }
        this.f50138s.postDelayed(runnable, j4);
    }
}
