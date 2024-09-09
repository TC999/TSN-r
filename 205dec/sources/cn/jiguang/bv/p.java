package cn.jiguang.bv;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private final int f3002a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadPoolExecutor f3003b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f3004c;

    /* renamed from: e  reason: collision with root package name */
    private final cn.jiguang.bv.a<Object> f3006e;

    /* renamed from: g  reason: collision with root package name */
    private Object f3008g;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f3005d = new AtomicBoolean(true);

    /* renamed from: f  reason: collision with root package name */
    private volatile long f3007f = 0;

    /* renamed from: h  reason: collision with root package name */
    private CountDownLatch f3009h = new CountDownLatch(1);

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final ExecutorService f3011a;

        a(ExecutorService executorService) {
            super(p.c());
            this.f3011a = executorService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                if (this.f3011a.isShutdown()) {
                    cn.jiguang.bq.d.i("Step", "executor is shutdown");
                } else {
                    this.f3011a.submit((Callable) message.obj);
                }
            } catch (Throwable th) {
                cn.jiguang.bq.d.l("Step", "handleMessage e:" + th);
            }
        }
    }

    public p(int i4, int i5, cn.jiguang.bv.a<Object> aVar, String str) {
        this.f3002a = i5;
        this.f3006e = aVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i4, i4, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new cn.jiguang.cm.c(str)) { // from class: cn.jiguang.bv.p.1
            /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
                if (r1.f3010a.f3004c.hasMessages(233) == false) goto L9;
             */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
            @Override // java.util.concurrent.ThreadPoolExecutor
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            protected void afterExecute(java.lang.Runnable r2, java.lang.Throwable r3) {
                /*
                    r1 = this;
                    r2 = 1
                    int r3 = r1.getActiveCount()     // Catch: java.lang.Throwable -> L22
                    if (r3 > r2) goto L20
                    java.util.concurrent.BlockingQueue r3 = r1.getQueue()     // Catch: java.lang.Throwable -> L22
                    boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L22
                    if (r3 == 0) goto L20
                    cn.jiguang.bv.p r3 = cn.jiguang.bv.p.this     // Catch: java.lang.Throwable -> L22
                    android.os.Handler r3 = cn.jiguang.bv.p.a(r3)     // Catch: java.lang.Throwable -> L22
                    r0 = 233(0xe9, float:3.27E-43)
                    boolean r3 = r3.hasMessages(r0)     // Catch: java.lang.Throwable -> L22
                    if (r3 != 0) goto L20
                    goto L22
                L20:
                    r3 = 0
                    goto L23
                L22:
                    r3 = 1
                L23:
                    if (r3 == 0) goto L37
                    cn.jiguang.bv.p r3 = cn.jiguang.bv.p.this     // Catch: java.lang.Throwable -> L37
                    java.util.concurrent.atomic.AtomicBoolean r3 = cn.jiguang.bv.p.b(r3)     // Catch: java.lang.Throwable -> L37
                    r3.set(r2)     // Catch: java.lang.Throwable -> L37
                    cn.jiguang.bv.p r2 = cn.jiguang.bv.p.this     // Catch: java.lang.Throwable -> L37
                    java.util.concurrent.CountDownLatch r2 = cn.jiguang.bv.p.c(r2)     // Catch: java.lang.Throwable -> L37
                    r2.countDown()     // Catch: java.lang.Throwable -> L37
                L37:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bv.p.AnonymousClass1.afterExecute(java.lang.Runnable, java.lang.Throwable):void");
            }
        };
        this.f3003b = threadPoolExecutor;
        this.f3004c = new a(threadPoolExecutor);
    }

    private synchronized long b(long j4) {
        long j5 = this.f3007f + j4;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (j5 < uptimeMillis) {
            this.f3007f = uptimeMillis;
            return -1L;
        }
        this.f3007f = j5;
        return j5;
    }

    static /* synthetic */ Looper c() {
        return d();
    }

    private static Looper d() {
        HandlerThread handlerThread = new HandlerThread("jg_step_thread") { // from class: cn.jiguang.bv.p.2
            @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        };
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        return looper == null ? Looper.getMainLooper() : looper;
    }

    public synchronized Object a(long j4) {
        if (a()) {
            return this.f3008g;
        } else if (this.f3005d.get()) {
            return null;
        } else {
            try {
                if (j4 != -1) {
                    this.f3009h.await(j4, TimeUnit.MILLISECONDS);
                } else {
                    this.f3009h.await();
                }
            } catch (InterruptedException unused) {
            }
            if (this.f3009h.getCount() == 0) {
                this.f3009h = new CountDownLatch(1);
            }
            return this.f3008g;
        }
    }

    public void a(Object obj) {
        if (a() || obj == null) {
            return;
        }
        this.f3008g = obj;
        this.f3009h.countDown();
        cn.jiguang.bv.a<Object> aVar = this.f3006e;
        if (aVar != null) {
            aVar.a(obj);
        }
        a(true);
        cn.jiguang.bq.d.c("Step", "done!");
    }

    public void a(Callable<?> callable) {
        try {
            long b4 = b(this.f3002a);
            if (b4 < 0) {
                this.f3003b.submit(callable);
            } else {
                Message obtain = Message.obtain();
                obtain.what = 233;
                obtain.obj = callable;
                this.f3004c.sendMessageAtTime(obtain, b4);
            }
            this.f3005d.set(false);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z3) {
        this.f3004c.removeMessages(233);
        if (!this.f3003b.isShutdown()) {
            if (z3) {
                this.f3003b.shutdownNow();
            } else {
                this.f3003b.shutdown();
            }
        }
        try {
            this.f3004c.getLooper().quit();
        } catch (Throwable unused) {
        }
        cn.jiguang.bq.d.c("Step", "StepParallelScheduler stop !");
    }

    public boolean a() {
        return this.f3008g != null;
    }

    public void b() {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f3003b;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.getQueue().clear();
                this.f3004c.removeMessages(233);
            }
        } catch (Throwable th) {
            Log.w("Step", "clean executor e:" + th);
        }
    }
}
