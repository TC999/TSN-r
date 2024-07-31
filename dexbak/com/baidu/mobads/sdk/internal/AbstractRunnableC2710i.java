package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;

/* renamed from: com.baidu.mobads.sdk.internal.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractRunnableC2710i<T> implements Runnable {

    /* renamed from: b */
    private static final String f9071b = "BaseTask";

    /* renamed from: c */
    private static final int f9072c = 1;

    /* renamed from: d */
    private static final int f9073d = 2;

    /* renamed from: e */
    private static final int f9074e = 3;

    /* renamed from: j */
    private static HandlerC2712b f9075j;

    /* renamed from: a */
    protected Future<T> f9076a;

    /* renamed from: f */
    private String f9077f;

    /* renamed from: g */
    private long f9078g;

    /* renamed from: h */
    private long f9079h;

    /* renamed from: i */
    private long f9080i;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mobads.sdk.internal.i$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2711a<T> {

        /* renamed from: a */
        final AbstractRunnableC2710i f9081a;

        /* renamed from: b */
        final T f9082b;

        C2711a(AbstractRunnableC2710i abstractRunnableC2710i, T t) {
            this.f9081a = abstractRunnableC2710i;
            this.f9082b = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.mobads.sdk.internal.i$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class HandlerC2712b extends Handler {
        public HandlerC2712b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C2711a c2711a = (C2711a) message.obj;
            int i = message.what;
            if (i == 1) {
                c2711a.f9081a.m50387a((AbstractRunnableC2710i) c2711a.f9082b);
            } else if (i == 2) {
                c2711a.f9081a.m50386a((Throwable) c2711a.f9082b);
            } else if (i != 3) {
            } else {
                c2711a.f9081a.m50375j();
            }
        }
    }

    public AbstractRunnableC2710i() {
        this.f9077f = "default";
    }

    /* renamed from: k */
    private static Handler m50374k() {
        HandlerC2712b handlerC2712b;
        synchronized (AbstractRunnableC2710i.class) {
            if (f9075j == null) {
                f9075j = new HandlerC2712b(Looper.getMainLooper());
            }
            handlerC2712b = f9075j;
        }
        return handlerC2712b;
    }

    /* renamed from: a */
    public String m50389a() {
        return this.f9077f;
    }

    /* renamed from: a */
    protected void m50387a(T t) {
    }

    /* renamed from: a */
    protected void m50386a(Throwable th) {
    }

    /* renamed from: b */
    public void m50383b() {
        m50384a(false);
    }

    /* renamed from: c */
    public boolean m50382c() {
        Future<T> future = this.f9076a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    /* renamed from: d */
    public boolean m50381d() {
        Future<T> future = this.f9076a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    /* renamed from: e */
    public long m50380e() {
        return this.f9079h - this.f9078g;
    }

    /* renamed from: f */
    public long m50379f() {
        return this.f9080i - this.f9078g;
    }

    /* renamed from: g */
    public long m50378g() {
        return this.f9080i - this.f9079h;
    }

    /* renamed from: h */
    public AbstractRunnableC2710i m50377h() {
        try {
            this.f9079h = System.currentTimeMillis();
            m50374k().obtainMessage(1, new C2711a(this, mo50376i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    /* renamed from: i */
    protected abstract T mo50376i();

    /* renamed from: j */
    protected void m50375j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        m50377h();
    }

    /* renamed from: a */
    public void m50385a(Future future) {
        this.f9076a = future;
    }

    public AbstractRunnableC2710i(String str) {
        this.f9077f = str;
    }

    /* renamed from: a */
    public void m50388a(long j) {
        this.f9078g = j;
    }

    /* renamed from: a */
    public void m50384a(boolean z) {
        Future<T> future = this.f9076a;
        if (future != null) {
            future.cancel(z);
            m50374k().obtainMessage(3, new C2711a(this, null)).sendToTarget();
        }
    }
}
