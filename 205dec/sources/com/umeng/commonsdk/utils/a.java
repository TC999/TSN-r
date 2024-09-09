package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: CountDownTimer.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    private static final int f53767e = 1;

    /* renamed from: a  reason: collision with root package name */
    private final long f53768a;

    /* renamed from: b  reason: collision with root package name */
    private final long f53769b;

    /* renamed from: c  reason: collision with root package name */
    private long f53770c;

    /* renamed from: f  reason: collision with root package name */
    private HandlerThread f53772f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f53773g;

    /* renamed from: d  reason: collision with root package name */
    private boolean f53771d = false;

    /* renamed from: h  reason: collision with root package name */
    private Handler.Callback f53774h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f53771d) {
                    return true;
                }
                long elapsedRealtime = a.this.f53770c - SystemClock.elapsedRealtime();
                if (elapsedRealtime > 0) {
                    if (elapsedRealtime < a.this.f53769b) {
                        a.this.f53773g.sendMessageDelayed(a.this.f53773g.obtainMessage(1), elapsedRealtime);
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        a.this.a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + a.this.f53769b) - SystemClock.elapsedRealtime();
                        while (elapsedRealtime3 < 0) {
                            elapsedRealtime3 += a.this.f53769b;
                        }
                        a.this.f53773g.sendMessageDelayed(a.this.f53773g.obtainMessage(1), elapsedRealtime3);
                    }
                } else {
                    a.this.c();
                    if (a.this.f53772f != null) {
                        a.this.f53772f.quit();
                    }
                }
                return false;
            }
        }
    };

    public a(long j4, long j5) {
        this.f53768a = j4;
        this.f53769b = j5;
        if (!d()) {
            HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
            this.f53772f = handlerThread;
            handlerThread.start();
            this.f53773g = new Handler(this.f53772f.getLooper(), this.f53774h);
            return;
        }
        this.f53773g = new Handler(this.f53774h);
    }

    public abstract void a(long j4);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f53771d = true;
        this.f53773g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f53771d = false;
        if (this.f53768a <= 0) {
            c();
            return this;
        }
        this.f53770c = SystemClock.elapsedRealtime() + this.f53768a;
        Handler handler = this.f53773g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
