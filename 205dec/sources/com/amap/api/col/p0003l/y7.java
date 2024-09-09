package com.amap.api.col.p0003l;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: BasicThreadFactory.java */
/* renamed from: com.amap.api.col.3l.y7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class y7 implements ThreadFactory {

    /* renamed from: k  reason: collision with root package name */
    private static final int f9530k;

    /* renamed from: l  reason: collision with root package name */
    private static final int f9531l;

    /* renamed from: m  reason: collision with root package name */
    private static final int f9532m;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f9533a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadFactory f9534b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f9535c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9536d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f9537e;

    /* renamed from: f  reason: collision with root package name */
    private final Boolean f9538f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9539g;

    /* renamed from: h  reason: collision with root package name */
    private final int f9540h;

    /* renamed from: i  reason: collision with root package name */
    private final BlockingQueue<Runnable> f9541i;

    /* renamed from: j  reason: collision with root package name */
    private final int f9542j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BasicThreadFactory.java */
    /* renamed from: com.amap.api.col.3l.y7$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f9543a;

        a(Runnable runnable) {
            this.f9543a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f9543a.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: BasicThreadFactory.java */
    /* renamed from: com.amap.api.col.3l.y7$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private ThreadFactory f9545a;

        /* renamed from: b  reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f9546b;

        /* renamed from: c  reason: collision with root package name */
        private String f9547c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f9548d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f9549e;

        /* renamed from: f  reason: collision with root package name */
        private int f9550f = y7.f9531l;

        /* renamed from: g  reason: collision with root package name */
        private int f9551g = y7.f9532m;

        /* renamed from: h  reason: collision with root package name */
        private int f9552h = 30;

        /* renamed from: i  reason: collision with root package name */
        private BlockingQueue<Runnable> f9553i;

        private void j() {
            this.f9545a = null;
            this.f9546b = null;
            this.f9547c = null;
            this.f9548d = null;
            this.f9549e = null;
        }

        public final b a() {
            this.f9550f = 1;
            return this;
        }

        public final b b(int i4) {
            if (this.f9550f > 0) {
                this.f9551g = i4;
                return this;
            }
            throw new NullPointerException("corePoolSize  must > 0!");
        }

        public final b c(String str) {
            if (str != null) {
                this.f9547c = str;
                return this;
            }
            throw new NullPointerException("Naming pattern must not be null!");
        }

        public final b d(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler != null) {
                this.f9546b = uncaughtExceptionHandler;
                return this;
            }
            throw new NullPointerException("Uncaught exception handler must not be null!");
        }

        public final b e(BlockingQueue<Runnable> blockingQueue) {
            this.f9553i = blockingQueue;
            return this;
        }

        public final y7 h() {
            y7 y7Var = new y7(this, (byte) 0);
            j();
            return y7Var;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f9530k = availableProcessors;
        f9531l = Math.max(2, Math.min(availableProcessors - 1, 4));
        f9532m = (availableProcessors * 2) + 1;
    }

    /* synthetic */ y7(b bVar, byte b4) {
        this(bVar);
    }

    private ThreadFactory g() {
        return this.f9534b;
    }

    private String h() {
        return this.f9536d;
    }

    private Boolean i() {
        return this.f9538f;
    }

    private Integer j() {
        return this.f9537e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.f9535c;
    }

    public final int a() {
        return this.f9539g;
    }

    public final int b() {
        return this.f9540h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.f9541i;
    }

    public final int d() {
        return this.f9542j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        new a(runnable);
        Thread newThread = g().newThread(runnable);
        if (h() != null) {
            Long valueOf = Long.valueOf(this.f9533a.incrementAndGet());
            newThread.setName(String.format(h() + "-%d", valueOf));
        }
        if (k() != null) {
            newThread.setUncaughtExceptionHandler(k());
        }
        if (j() != null) {
            newThread.setPriority(j().intValue());
        }
        if (i() != null) {
            newThread.setDaemon(i().booleanValue());
        }
        return newThread;
    }

    private y7(b bVar) {
        if (bVar.f9545a == null) {
            this.f9534b = Executors.defaultThreadFactory();
        } else {
            this.f9534b = bVar.f9545a;
        }
        int i4 = bVar.f9550f;
        this.f9539g = i4;
        int i5 = f9532m;
        this.f9540h = i5;
        if (i5 >= i4) {
            this.f9542j = bVar.f9552h;
            if (bVar.f9553i == null) {
                this.f9541i = new LinkedBlockingQueue(256);
            } else {
                this.f9541i = bVar.f9553i;
            }
            if (TextUtils.isEmpty(bVar.f9547c)) {
                this.f9536d = "amap-threadpool";
            } else {
                this.f9536d = bVar.f9547c;
            }
            this.f9537e = bVar.f9548d;
            this.f9538f = bVar.f9549e;
            this.f9535c = bVar.f9546b;
            this.f9533a = new AtomicLong();
            return;
        }
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }
}
