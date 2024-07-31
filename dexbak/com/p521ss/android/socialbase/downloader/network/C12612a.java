package com.p521ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p555p.C12659n;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.ss.android.socialbase.downloader.network.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12612a {

    /* renamed from: a */
    private static final String f35548a = "a";

    /* renamed from: h */
    private static long f35549h = -1;

    /* renamed from: ok */
    public static volatile boolean f35550ok;

    /* renamed from: p */
    private static volatile C12612a f35551p;

    /* renamed from: kf */
    private long f35553kf;

    /* renamed from: bl */
    private final C12636r f35552bl = C12636r.m16905ok();

    /* renamed from: s */
    private final AtomicInteger f35555s = new AtomicInteger();

    /* renamed from: n */
    private final HandlerC12613ok f35554n = new HandlerC12613ok(C12659n.m16748ok());

    /* renamed from: com.ss.android.socialbase.downloader.network.a$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class HandlerC12613ok extends Handler {
        public HandlerC12613ok(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void m16955a() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            C12612a.this.m16959kf();
            sendEmptyMessageDelayed(1, 1000L);
        }

        /* renamed from: ok */
        public void m16954ok() {
            sendEmptyMessage(1);
        }
    }

    private C12612a() {
    }

    /* renamed from: n */
    public static void m16958n() {
        f35550ok = C12713kf.m16620a(C12490bl.m17807l());
    }

    /* renamed from: ok */
    public static C12612a m16957ok() {
        if (f35551p == null) {
            synchronized (C12612a.class) {
                if (f35551p == null) {
                    f35551p = new C12612a();
                }
            }
        }
        return f35551p;
    }

    /* renamed from: s */
    public static long m16956s() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    /* renamed from: a */
    public void m16962a() {
        try {
            String str = f35548a;
            C12409ok.m17901bl(str, "startSampling: mSamplingCounter = " + this.f35555s);
            if (this.f35555s.getAndIncrement() == 0) {
                this.f35554n.m16954ok();
                this.f35553kf = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: bl */
    public void m16961bl() {
        try {
            String str = f35548a;
            C12409ok.m17901bl(str, "stopSampling: mSamplingCounter = " + this.f35555s);
            if (this.f35555s.decrementAndGet() == 0) {
                this.f35554n.m16955a();
                m16960h();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: h */
    protected void m16960h() {
        m16959kf();
        f35549h = -1L;
    }

    /* renamed from: kf */
    protected void m16959kf() {
        long mobileRxBytes;
        try {
            m16958n();
            if (f35550ok) {
                mobileRxBytes = m16956s();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = f35549h;
            long j2 = mobileRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f35552bl.m16903ok(j2, uptimeMillis - this.f35553kf);
                    this.f35553kf = uptimeMillis;
                }
            }
            f35549h = mobileRxBytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
