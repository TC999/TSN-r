package com.amap.api.col.p047s;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BasicThreadFactory.java */
/* renamed from: com.amap.api.col.s.x3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ThreadFactoryC2209x3 implements ThreadFactory {

    /* renamed from: k */
    private static final int f6720k;

    /* renamed from: l */
    private static final int f6721l;

    /* renamed from: m */
    private static final int f6722m;

    /* renamed from: a */
    private final AtomicLong f6723a;

    /* renamed from: b */
    private final ThreadFactory f6724b;

    /* renamed from: c */
    private final Thread.UncaughtExceptionHandler f6725c;

    /* renamed from: d */
    private final String f6726d;

    /* renamed from: e */
    private final Integer f6727e;

    /* renamed from: f */
    private final Boolean f6728f;

    /* renamed from: g */
    private final int f6729g;

    /* renamed from: h */
    private final int f6730h;

    /* renamed from: i */
    private final BlockingQueue<Runnable> f6731i;

    /* renamed from: j */
    private final int f6732j;

    /* compiled from: BasicThreadFactory.java */
    /* renamed from: com.amap.api.col.s.x3$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2210a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f6733a;

        RunnableC2210a(Runnable runnable) {
            this.f6733a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f6733a.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: BasicThreadFactory.java */
    /* renamed from: com.amap.api.col.s.x3$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2211b {

        /* renamed from: a */
        private ThreadFactory f6735a;

        /* renamed from: b */
        private Thread.UncaughtExceptionHandler f6736b;

        /* renamed from: c */
        private String f6737c;

        /* renamed from: d */
        private Integer f6738d;

        /* renamed from: e */
        private Boolean f6739e;

        /* renamed from: f */
        private int f6740f = ThreadFactoryC2209x3.f6721l;

        /* renamed from: g */
        private int f6741g = ThreadFactoryC2209x3.f6722m;

        /* renamed from: h */
        private int f6742h = 30;

        /* renamed from: i */
        private BlockingQueue<Runnable> f6743i;

        /* renamed from: e */
        private void m52262e() {
            this.f6735a = null;
            this.f6736b = null;
            this.f6737c = null;
            this.f6738d = null;
            this.f6739e = null;
        }

        /* renamed from: a */
        public final C2211b m52266a(String str) {
            this.f6737c = str;
            return this;
        }

        /* renamed from: b */
        public final ThreadFactoryC2209x3 m52265b() {
            ThreadFactoryC2209x3 threadFactoryC2209x3 = new ThreadFactoryC2209x3(this, (byte) 0);
            m52262e();
            return threadFactoryC2209x3;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f6720k = availableProcessors;
        f6721l = Math.max(2, Math.min(availableProcessors - 1, 4));
        f6722m = (availableProcessors * 2) + 1;
    }

    /* synthetic */ ThreadFactoryC2209x3(C2211b c2211b, byte b) {
        this(c2211b);
    }

    /* renamed from: g */
    private ThreadFactory m52271g() {
        return this.f6724b;
    }

    /* renamed from: h */
    private String m52270h() {
        return this.f6726d;
    }

    /* renamed from: i */
    private Boolean m52269i() {
        return this.f6728f;
    }

    /* renamed from: j */
    private Integer m52268j() {
        return this.f6727e;
    }

    /* renamed from: k */
    private Thread.UncaughtExceptionHandler m52267k() {
        return this.f6725c;
    }

    /* renamed from: a */
    public final int m52277a() {
        return this.f6729g;
    }

    /* renamed from: b */
    public final int m52276b() {
        return this.f6730h;
    }

    /* renamed from: c */
    public final BlockingQueue<Runnable> m52275c() {
        return this.f6731i;
    }

    /* renamed from: d */
    public final int m52274d() {
        return this.f6732j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        new RunnableC2210a(runnable);
        Thread newThread = m52271g().newThread(runnable);
        if (m52270h() != null) {
            Long valueOf = Long.valueOf(this.f6723a.incrementAndGet());
            newThread.setName(String.format(m52270h() + "-%d", valueOf));
        }
        if (m52267k() != null) {
            newThread.setUncaughtExceptionHandler(m52267k());
        }
        if (m52268j() != null) {
            newThread.setPriority(m52268j().intValue());
        }
        if (m52269i() != null) {
            newThread.setDaemon(m52269i().booleanValue());
        }
        return newThread;
    }

    private ThreadFactoryC2209x3(C2211b c2211b) {
        if (c2211b.f6735a == null) {
            this.f6724b = Executors.defaultThreadFactory();
        } else {
            this.f6724b = c2211b.f6735a;
        }
        int i = c2211b.f6740f;
        this.f6729g = i;
        int i2 = f6722m;
        this.f6730h = i2;
        if (i2 >= i) {
            this.f6732j = c2211b.f6742h;
            if (c2211b.f6743i == null) {
                this.f6731i = new LinkedBlockingQueue(256);
            } else {
                this.f6731i = c2211b.f6743i;
            }
            if (TextUtils.isEmpty(c2211b.f6737c)) {
                this.f6726d = "amap-threadpool";
            } else {
                this.f6726d = c2211b.f6737c;
            }
            this.f6727e = c2211b.f6738d;
            this.f6728f = c2211b.f6739e;
            this.f6725c = c2211b.f6736b;
            this.f6723a = new AtomicLong();
            return;
        }
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }
}
