package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: com.umeng.commonsdk.utils.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class CountDownTimer {

    /* renamed from: e */
    private static final int f39132e = 1;

    /* renamed from: a */
    private final long f39133a;

    /* renamed from: b */
    private final long f39134b;

    /* renamed from: c */
    private long f39135c;

    /* renamed from: f */
    private HandlerThread f39137f;

    /* renamed from: g */
    private Handler f39138g;

    /* renamed from: d */
    private boolean f39136d = false;

    /* renamed from: h */
    private Handler.Callback f39139h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (CountDownTimer.this) {
                if (CountDownTimer.this.f39136d) {
                    return true;
                }
                long elapsedRealtime = CountDownTimer.this.f39135c - SystemClock.elapsedRealtime();
                if (elapsedRealtime > 0) {
                    if (elapsedRealtime < CountDownTimer.this.f39134b) {
                        CountDownTimer.this.f39138g.sendMessageDelayed(CountDownTimer.this.f39138g.obtainMessage(1), elapsedRealtime);
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        CountDownTimer.this.m13475a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + CountDownTimer.this.f39134b) - SystemClock.elapsedRealtime();
                        while (elapsedRealtime3 < 0) {
                            elapsedRealtime3 += CountDownTimer.this.f39134b;
                        }
                        CountDownTimer.this.f39138g.sendMessageDelayed(CountDownTimer.this.f39138g.obtainMessage(1), elapsedRealtime3);
                    }
                } else {
                    CountDownTimer.this.m13471c();
                    if (CountDownTimer.this.f39137f != null) {
                        CountDownTimer.this.f39137f.quit();
                    }
                }
                return false;
            }
        }
    };

    public CountDownTimer(long j, long j2) {
        this.f39133a = j;
        this.f39134b = j2;
        if (!m13469d()) {
            HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
            this.f39137f = handlerThread;
            handlerThread.start();
            this.f39138g = new Handler(this.f39137f.getLooper(), this.f39139h);
            return;
        }
        this.f39138g = new Handler(this.f39139h);
    }

    /* renamed from: a */
    public abstract void m13475a(long j);

    /* renamed from: c */
    public abstract void m13471c();

    /* renamed from: d */
    private boolean m13469d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    /* renamed from: a */
    public final synchronized void m13476a() {
        this.f39136d = true;
        this.f39138g.removeMessages(1);
    }

    /* renamed from: b */
    public final synchronized CountDownTimer m13473b() {
        this.f39136d = false;
        if (this.f39133a <= 0) {
            m13471c();
            return this;
        }
        this.f39135c = SystemClock.elapsedRealtime() + this.f39133a;
        Handler handler = this.f39138g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
