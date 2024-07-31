package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ChoreographerCompat {

    /* renamed from: c */
    private static final long f23440c = 17;

    /* renamed from: d */
    private static final boolean f23441d = true;

    /* renamed from: e */
    private static ChoreographerCompat f23442e = new ChoreographerCompat();

    /* renamed from: a */
    private Handler f23443a;

    /* renamed from: b */
    private Choreographer f23444b;

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static abstract class FrameCallback {

        /* renamed from: a */
        private Runnable f23445a;

        /* renamed from: b */
        private Choreographer.FrameCallback f23446b;

        /* renamed from: a */
        public abstract void mo35609a(long j);

        @TargetApi(16)
        /* renamed from: b */
        Choreographer.FrameCallback m35608b() {
            if (this.f23446b == null) {
                this.f23446b = new Choreographer.FrameCallback() { // from class: com.facebook.rebound.ChoreographerCompat.FrameCallback.1
                    @Override // android.view.Choreographer.FrameCallback
                    public void doFrame(long j) {
                        FrameCallback.this.mo35609a(j);
                    }
                };
            }
            return this.f23446b;
        }

        /* renamed from: c */
        Runnable m35607c() {
            if (this.f23445a == null) {
                this.f23445a = new Runnable() { // from class: com.facebook.rebound.ChoreographerCompat.FrameCallback.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FrameCallback.this.mo35609a(System.nanoTime());
                    }
                };
            }
            return this.f23445a;
        }
    }

    private ChoreographerCompat() {
        if (f23441d) {
            this.f23444b = m35614d();
        } else {
            this.f23443a = new Handler(Looper.getMainLooper());
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    private void m35617a(Choreographer.FrameCallback frameCallback) {
        this.f23444b.postFrameCallback(frameCallback);
    }

    @TargetApi(16)
    /* renamed from: b */
    private void m35616b(Choreographer.FrameCallback frameCallback, long j) {
        this.f23444b.postFrameCallbackDelayed(frameCallback, j);
    }

    @TargetApi(16)
    /* renamed from: c */
    private void m35615c(Choreographer.FrameCallback frameCallback) {
        this.f23444b.removeFrameCallback(frameCallback);
    }

    @TargetApi(16)
    /* renamed from: d */
    private Choreographer m35614d() {
        return Choreographer.getInstance();
    }

    /* renamed from: e */
    public static ChoreographerCompat m35613e() {
        return f23442e;
    }

    /* renamed from: f */
    public void m35612f(FrameCallback frameCallback) {
        if (f23441d) {
            m35617a(frameCallback.m35608b());
        } else {
            this.f23443a.postDelayed(frameCallback.m35607c(), 0L);
        }
    }

    /* renamed from: g */
    public void m35611g(FrameCallback frameCallback, long j) {
        if (f23441d) {
            m35616b(frameCallback.m35608b(), j);
        } else {
            this.f23443a.postDelayed(frameCallback.m35607c(), j + f23440c);
        }
    }

    /* renamed from: h */
    public void m35610h(FrameCallback frameCallback) {
        if (f23441d) {
            m35615c(frameCallback.m35608b());
        } else {
            this.f23443a.removeCallbacks(frameCallback.m35607c());
        }
    }
}
