package com.amap.api.col.p0463l;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.amap.api.col.3l.x7 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class BasicThreadFactory implements ThreadFactory {

    /* renamed from: k */
    private static final int f5688k;

    /* renamed from: l */
    private static final int f5689l;

    /* renamed from: m */
    private static final int f5690m;

    /* renamed from: a */
    private final AtomicLong f5691a;

    /* renamed from: b */
    private final ThreadFactory f5692b;

    /* renamed from: c */
    private final Thread.UncaughtExceptionHandler f5693c;

    /* renamed from: d */
    private final String f5694d;

    /* renamed from: e */
    private final Integer f5695e;

    /* renamed from: f */
    private final Boolean f5696f;

    /* renamed from: g */
    private final int f5697g;

    /* renamed from: h */
    private final int f5698h;

    /* renamed from: i */
    private final BlockingQueue<Runnable> f5699i;

    /* renamed from: j */
    private final int f5700j;

    /* compiled from: BasicThreadFactory.java */
    /* renamed from: com.amap.api.col.3l.x7$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC1987a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f5701a;

        RunnableC1987a(Runnable runnable) {
            this.f5701a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f5701a.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: BasicThreadFactory.java */
    /* renamed from: com.amap.api.col.3l.x7$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1988b {

        /* renamed from: a */
        private ThreadFactory f5703a;

        /* renamed from: b */
        private Thread.UncaughtExceptionHandler f5704b;

        /* renamed from: c */
        private String f5705c;

        /* renamed from: d */
        private Integer f5706d;

        /* renamed from: e */
        private Boolean f5707e;

        /* renamed from: f */
        private int f5708f = BasicThreadFactory.f5689l;

        /* renamed from: g */
        private int f5709g = BasicThreadFactory.f5690m;

        /* renamed from: h */
        private int f5710h = 30;

        /* renamed from: i */
        private BlockingQueue<Runnable> f5711i;

        /* renamed from: j */
        private void m53503j() {
            this.f5703a = null;
            this.f5704b = null;
            this.f5705c = null;
            this.f5706d = null;
            this.f5707e = null;
        }

        /* renamed from: a */
        public final C1988b m53512a() {
            this.f5708f = 1;
            return this;
        }

        /* renamed from: b */
        public final C1988b m53511b(int i) {
            if (this.f5708f > 0) {
                this.f5709g = i;
                return this;
            }
            throw new NullPointerException("corePoolSize  must > 0!");
        }

        /* renamed from: c */
        public final C1988b m53510c(String str) {
            if (str != null) {
                this.f5705c = str;
                return this;
            }
            throw new NullPointerException("Naming pattern must not be null!");
        }

        /* renamed from: d */
        public final C1988b m53509d(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler != null) {
                this.f5704b = uncaughtExceptionHandler;
                return this;
            }
            throw new NullPointerException("Uncaught exception handler must not be null!");
        }

        /* renamed from: e */
        public final C1988b m53508e(BlockingQueue<Runnable> blockingQueue) {
            this.f5711i = blockingQueue;
            return this;
        }

        /* renamed from: h */
        public final BasicThreadFactory m53505h() {
            BasicThreadFactory basicThreadFactory = new BasicThreadFactory(this, (byte) 0);
            m53503j();
            return basicThreadFactory;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f5688k = availableProcessors;
        f5689l = Math.max(2, Math.min(availableProcessors - 1, 4));
        f5690m = (availableProcessors * 2) + 1;
    }

    /* synthetic */ BasicThreadFactory(C1988b c1988b, byte b) {
        this(c1988b);
    }

    /* renamed from: g */
    private ThreadFactory m53517g() {
        return this.f5692b;
    }

    /* renamed from: h */
    private String m53516h() {
        return this.f5694d;
    }

    /* renamed from: i */
    private Boolean m53515i() {
        return this.f5696f;
    }

    /* renamed from: j */
    private Integer m53514j() {
        return this.f5695e;
    }

    /* renamed from: k */
    private Thread.UncaughtExceptionHandler m53513k() {
        return this.f5693c;
    }

    /* renamed from: a */
    public final int m53523a() {
        return this.f5697g;
    }

    /* renamed from: b */
    public final int m53522b() {
        return this.f5698h;
    }

    /* renamed from: c */
    public final BlockingQueue<Runnable> m53521c() {
        return this.f5699i;
    }

    /* renamed from: d */
    public final int m53520d() {
        return this.f5700j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        new RunnableC1987a(runnable);
        Thread newThread = m53517g().newThread(runnable);
        if (m53516h() != null) {
            Long valueOf = Long.valueOf(this.f5691a.incrementAndGet());
            newThread.setName(String.format(m53516h() + "-%d", valueOf));
        }
        if (m53513k() != null) {
            newThread.setUncaughtExceptionHandler(m53513k());
        }
        if (m53514j() != null) {
            newThread.setPriority(m53514j().intValue());
        }
        if (m53515i() != null) {
            newThread.setDaemon(m53515i().booleanValue());
        }
        return newThread;
    }

    private BasicThreadFactory(C1988b c1988b) {
        if (c1988b.f5703a == null) {
            this.f5692b = Executors.defaultThreadFactory();
        } else {
            this.f5692b = c1988b.f5703a;
        }
        int i = c1988b.f5708f;
        this.f5697g = i;
        int i2 = f5690m;
        this.f5698h = i2;
        if (i2 >= i) {
            this.f5700j = c1988b.f5710h;
            if (c1988b.f5711i == null) {
                this.f5699i = new LinkedBlockingQueue(256);
            } else {
                this.f5699i = c1988b.f5711i;
            }
            if (TextUtils.isEmpty(c1988b.f5705c)) {
                this.f5694d = "amap-threadpool";
            } else {
                this.f5694d = c1988b.f5705c;
            }
            this.f5695e = c1988b.f5706d;
            this.f5696f = c1988b.f5707e;
            this.f5693c = c1988b.f5704b;
            this.f5691a = new AtomicLong();
            return;
        }
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }
}
