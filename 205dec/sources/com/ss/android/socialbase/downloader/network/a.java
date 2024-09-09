package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f50004a = "a";

    /* renamed from: h  reason: collision with root package name */
    private static long f50005h = -1;
    public static volatile boolean ok;

    /* renamed from: p  reason: collision with root package name */
    private static volatile a f50006p;
    private long kf;
    private final r bl = r.ok();

    /* renamed from: s  reason: collision with root package name */
    private final AtomicInteger f50008s = new AtomicInteger();

    /* renamed from: n  reason: collision with root package name */
    private final ok f50007n = new ok(com.ss.android.socialbase.downloader.p.n.ok());

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class ok extends Handler {
        public ok(Looper looper) {
            super(looper);
        }

        public void a() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            a.this.kf();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void ok() {
            sendEmptyMessage(1);
        }
    }

    private a() {
    }

    public static void n() {
        ok = com.ss.android.socialbase.downloader.q.kf.a(com.ss.android.socialbase.downloader.downloader.bl.l());
    }

    public static a ok() {
        if (f50006p == null) {
            synchronized (a.class) {
                if (f50006p == null) {
                    f50006p = new a();
                }
            }
        }
        return f50006p;
    }

    public static long s() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public void a() {
        try {
            String str = f50004a;
            com.ss.android.socialbase.downloader.bl.ok.bl(str, "startSampling: mSamplingCounter = " + this.f50008s);
            if (this.f50008s.getAndIncrement() == 0) {
                this.f50007n.ok();
                this.kf = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void bl() {
        try {
            String str = f50004a;
            com.ss.android.socialbase.downloader.bl.ok.bl(str, "stopSampling: mSamplingCounter = " + this.f50008s);
            if (this.f50008s.decrementAndGet() == 0) {
                this.f50007n.a();
                h();
            }
        } catch (Throwable unused) {
        }
    }

    protected void h() {
        kf();
        f50005h = -1L;
    }

    protected void kf() {
        long mobileRxBytes;
        try {
            n();
            if (ok) {
                mobileRxBytes = s();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j4 = f50005h;
            long j5 = mobileRxBytes - j4;
            if (j4 >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.bl.ok(j5, uptimeMillis - this.kf);
                    this.kf = uptimeMillis;
                }
            }
            f50005h = mobileRxBytes;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
