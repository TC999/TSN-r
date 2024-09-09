package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class c2 {

    /* renamed from: a  reason: collision with root package name */
    private final long f46393a;

    /* renamed from: b  reason: collision with root package name */
    private final long f46394b;

    /* renamed from: c  reason: collision with root package name */
    private long f46395c;

    /* renamed from: d  reason: collision with root package name */
    private long f46396d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f46397e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f46398f = false;

    /* renamed from: g  reason: collision with root package name */
    private Handler f46399g = new a(Looper.getMainLooper());

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (c2.this) {
                if (!c2.this.f46397e && !c2.this.f46398f) {
                    long elapsedRealtime = c2.this.f46395c - SystemClock.elapsedRealtime();
                    if (elapsedRealtime <= 0) {
                        c2.this.d();
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        c2.this.a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + c2.this.f46394b) - SystemClock.elapsedRealtime();
                        while (elapsedRealtime3 < 0) {
                            elapsedRealtime3 += c2.this.f46394b;
                        }
                        sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                    }
                }
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface b {
        void a(long j4);

        void b();
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends c2 {

        /* renamed from: h  reason: collision with root package name */
        private b f46401h;

        public c(long j4, long j5) {
            super(j4, j5);
        }

        public void a(b bVar) {
            this.f46401h = bVar;
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void d() {
            b bVar = this.f46401h;
            if (bVar != null) {
                bVar.b();
            }
        }

        @Override // com.qq.e.comm.plugin.util.c2
        public void a(long j4) {
            b bVar = this.f46401h;
            if (bVar != null) {
                bVar.a(j4);
            }
        }
    }

    public c2(long j4, long j5) {
        this.f46393a = j4;
        this.f46394b = j5;
    }

    public abstract void a(long j4);

    public abstract void d();

    public final synchronized void e() {
        if (!this.f46397e && !this.f46398f) {
            this.f46398f = true;
            this.f46396d = this.f46395c - SystemClock.elapsedRealtime();
            this.f46399g.removeMessages(1);
        }
    }

    public final synchronized void f() {
        if (!this.f46397e && this.f46398f) {
            this.f46398f = false;
            c(this.f46396d);
        }
    }

    public final synchronized void g() {
        c(this.f46393a);
    }

    public final synchronized void h() {
        this.f46397e = true;
        this.f46399g.removeMessages(1);
    }

    private synchronized c2 c(long j4) {
        this.f46397e = false;
        if (j4 <= 0) {
            d();
            return this;
        }
        this.f46395c = SystemClock.elapsedRealtime() + j4;
        Handler handler = this.f46399g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public final synchronized long a() {
        long elapsedRealtime;
        if (this.f46398f) {
            elapsedRealtime = this.f46396d;
        } else {
            elapsedRealtime = this.f46395c - SystemClock.elapsedRealtime();
        }
        if (elapsedRealtime <= 0) {
            return this.f46393a;
        }
        return this.f46393a - elapsedRealtime;
    }

    public void b(long j4) {
        this.f46396d = j4;
    }

    public long b() {
        return this.f46393a;
    }

    public long c() {
        return this.f46396d;
    }
}
