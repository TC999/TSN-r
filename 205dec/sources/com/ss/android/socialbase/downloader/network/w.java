package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f50059c = false;
    private static volatile w ev = null;

    /* renamed from: r  reason: collision with root package name */
    private static long f50060r = -1;

    /* renamed from: w  reason: collision with root package name */
    private static final String f50061w = "w";

    /* renamed from: f  reason: collision with root package name */
    private long f50062f;
    private final k xv = k.c();
    private final AtomicInteger sr = new AtomicInteger();
    private final c ux = new c(com.ss.android.socialbase.downloader.ev.ux.c());

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        public void c() {
            sendEmptyMessage(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            w.this.f();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void w() {
            removeMessages(1);
        }
    }

    private w() {
    }

    public static w c() {
        if (ev == null) {
            synchronized (w.class) {
                if (ev == null) {
                    ev = new w();
                }
            }
        }
        return ev;
    }

    public static long sr() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void ux() {
        f50059c = com.ss.android.socialbase.downloader.gd.f.w(com.ss.android.socialbase.downloader.downloader.xv.gw());
    }

    protected void f() {
        long mobileRxBytes;
        try {
            ux();
            if (f50059c) {
                mobileRxBytes = sr();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j4 = f50060r;
            long j5 = mobileRxBytes - j4;
            if (j4 >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.xv.c(j5, uptimeMillis - this.f50062f);
                    this.f50062f = uptimeMillis;
                }
            }
            f50060r = mobileRxBytes;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    protected void r() {
        f();
        f50060r = -1L;
    }

    public void w() {
        try {
            String str = f50061w;
            com.ss.android.socialbase.downloader.xv.c.xv(str, "startSampling: mSamplingCounter = " + this.sr);
            if (this.sr.getAndIncrement() == 0) {
                this.ux.c();
                this.f50062f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void xv() {
        try {
            String str = f50061w;
            com.ss.android.socialbase.downloader.xv.c.xv(str, "stopSampling: mSamplingCounter = " + this.sr);
            if (this.sr.decrementAndGet() == 0) {
                this.ux.w();
                r();
            }
        } catch (Throwable unused) {
        }
    }
}
