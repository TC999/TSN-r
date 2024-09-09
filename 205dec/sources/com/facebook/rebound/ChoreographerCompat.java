package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ChoreographerCompat {

    /* renamed from: c  reason: collision with root package name */
    private static final long f37036c = 17;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f37037d = true;

    /* renamed from: e  reason: collision with root package name */
    private static ChoreographerCompat f37038e = new ChoreographerCompat();

    /* renamed from: a  reason: collision with root package name */
    private Handler f37039a;

    /* renamed from: b  reason: collision with root package name */
    private Choreographer f37040b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static abstract class FrameCallback {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f37041a;

        /* renamed from: b  reason: collision with root package name */
        private Choreographer.FrameCallback f37042b;

        public abstract void a(long j4);

        @TargetApi(16)
        Choreographer.FrameCallback b() {
            if (this.f37042b == null) {
                this.f37042b = new Choreographer.FrameCallback() { // from class: com.facebook.rebound.ChoreographerCompat.FrameCallback.1
                    @Override // android.view.Choreographer.FrameCallback
                    public void doFrame(long j4) {
                        FrameCallback.this.a(j4);
                    }
                };
            }
            return this.f37042b;
        }

        Runnable c() {
            if (this.f37041a == null) {
                this.f37041a = new Runnable() { // from class: com.facebook.rebound.ChoreographerCompat.FrameCallback.2
                    @Override // java.lang.Runnable
                    public void run() {
                        FrameCallback.this.a(System.nanoTime());
                    }
                };
            }
            return this.f37041a;
        }
    }

    private ChoreographerCompat() {
        if (f37037d) {
            this.f37040b = d();
        } else {
            this.f37039a = new Handler(Looper.getMainLooper());
        }
    }

    @TargetApi(16)
    private void a(Choreographer.FrameCallback frameCallback) {
        this.f37040b.postFrameCallback(frameCallback);
    }

    @TargetApi(16)
    private void b(Choreographer.FrameCallback frameCallback, long j4) {
        this.f37040b.postFrameCallbackDelayed(frameCallback, j4);
    }

    @TargetApi(16)
    private void c(Choreographer.FrameCallback frameCallback) {
        this.f37040b.removeFrameCallback(frameCallback);
    }

    @TargetApi(16)
    private Choreographer d() {
        return Choreographer.getInstance();
    }

    public static ChoreographerCompat e() {
        return f37038e;
    }

    public void f(FrameCallback frameCallback) {
        if (f37037d) {
            a(frameCallback.b());
        } else {
            this.f37039a.postDelayed(frameCallback.c(), 0L);
        }
    }

    public void g(FrameCallback frameCallback, long j4) {
        if (f37037d) {
            b(frameCallback.b(), j4);
        } else {
            this.f37039a.postDelayed(frameCallback.c(), j4 + 17);
        }
    }

    public void h(FrameCallback frameCallback) {
        if (f37037d) {
            c(frameCallback.b());
        } else {
            this.f37039a.removeCallbacks(frameCallback.c());
        }
    }
}
