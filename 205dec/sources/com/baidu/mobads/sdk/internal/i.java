package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class i<T> implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private static final String f12857b = "BaseTask";

    /* renamed from: c  reason: collision with root package name */
    private static final int f12858c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f12859d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f12860e = 3;

    /* renamed from: j  reason: collision with root package name */
    private static b f12861j;

    /* renamed from: a  reason: collision with root package name */
    protected Future<T> f12862a;

    /* renamed from: f  reason: collision with root package name */
    private String f12863f;

    /* renamed from: g  reason: collision with root package name */
    private long f12864g;

    /* renamed from: h  reason: collision with root package name */
    private long f12865h;

    /* renamed from: i  reason: collision with root package name */
    private long f12866i;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        final i f12867a;

        /* renamed from: b  reason: collision with root package name */
        final T f12868b;

        a(i iVar, T t3) {
            this.f12867a = iVar;
            this.f12868b = t3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i4 = message.what;
            if (i4 == 1) {
                aVar.f12867a.a((i) aVar.f12868b);
            } else if (i4 == 2) {
                aVar.f12867a.a((Throwable) aVar.f12868b);
            } else if (i4 != 3) {
            } else {
                aVar.f12867a.j();
            }
        }
    }

    public i() {
        this.f12863f = "default";
    }

    private static Handler k() {
        b bVar;
        synchronized (i.class) {
            if (f12861j == null) {
                f12861j = new b(Looper.getMainLooper());
            }
            bVar = f12861j;
        }
        return bVar;
    }

    public String a() {
        return this.f12863f;
    }

    protected void a(T t3) {
    }

    protected void a(Throwable th) {
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.f12862a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.f12862a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.f12865h - this.f12864g;
    }

    public long f() {
        return this.f12866i - this.f12864g;
    }

    public long g() {
        return this.f12866i - this.f12865h;
    }

    public i h() {
        try {
            this.f12865h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    protected abstract T i();

    protected void j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public void a(Future future) {
        this.f12862a = future;
    }

    public i(String str) {
        this.f12863f = str;
    }

    public void a(long j4) {
        this.f12864g = j4;
    }

    public void a(boolean z3) {
        Future<T> future = this.f12862a;
        if (future != null) {
            future.cancel(z3);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }
}
