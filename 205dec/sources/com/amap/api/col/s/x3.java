package com.amap.api.col.s;

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
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x3 implements ThreadFactory {

    /* renamed from: k  reason: collision with root package name */
    private static final int f10448k;

    /* renamed from: l  reason: collision with root package name */
    private static final int f10449l;

    /* renamed from: m  reason: collision with root package name */
    private static final int f10450m;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f10451a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadFactory f10452b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f10453c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10454d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f10455e;

    /* renamed from: f  reason: collision with root package name */
    private final Boolean f10456f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10457g;

    /* renamed from: h  reason: collision with root package name */
    private final int f10458h;

    /* renamed from: i  reason: collision with root package name */
    private final BlockingQueue<Runnable> f10459i;

    /* renamed from: j  reason: collision with root package name */
    private final int f10460j;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BasicThreadFactory.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f10461a;

        a(Runnable runnable) {
            this.f10461a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f10461a.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: BasicThreadFactory.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private ThreadFactory f10463a;

        /* renamed from: b  reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f10464b;

        /* renamed from: c  reason: collision with root package name */
        private String f10465c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f10466d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f10467e;

        /* renamed from: f  reason: collision with root package name */
        private int f10468f = x3.f10449l;

        /* renamed from: g  reason: collision with root package name */
        private int f10469g = x3.f10450m;

        /* renamed from: h  reason: collision with root package name */
        private int f10470h = 30;

        /* renamed from: i  reason: collision with root package name */
        private BlockingQueue<Runnable> f10471i;

        private void e() {
            this.f10463a = null;
            this.f10464b = null;
            this.f10465c = null;
            this.f10466d = null;
            this.f10467e = null;
        }

        public final b a(String str) {
            this.f10465c = str;
            return this;
        }

        public final x3 b() {
            x3 x3Var = new x3(this, (byte) 0);
            e();
            return x3Var;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f10448k = availableProcessors;
        f10449l = Math.max(2, Math.min(availableProcessors - 1, 4));
        f10450m = (availableProcessors * 2) + 1;
    }

    /* synthetic */ x3(b bVar, byte b4) {
        this(bVar);
    }

    private ThreadFactory g() {
        return this.f10452b;
    }

    private String h() {
        return this.f10454d;
    }

    private Boolean i() {
        return this.f10456f;
    }

    private Integer j() {
        return this.f10455e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.f10453c;
    }

    public final int a() {
        return this.f10457g;
    }

    public final int b() {
        return this.f10458h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.f10459i;
    }

    public final int d() {
        return this.f10460j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        new a(runnable);
        Thread newThread = g().newThread(runnable);
        if (h() != null) {
            Long valueOf = Long.valueOf(this.f10451a.incrementAndGet());
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

    private x3(b bVar) {
        if (bVar.f10463a == null) {
            this.f10452b = Executors.defaultThreadFactory();
        } else {
            this.f10452b = bVar.f10463a;
        }
        int i4 = bVar.f10468f;
        this.f10457g = i4;
        int i5 = f10450m;
        this.f10458h = i5;
        if (i5 >= i4) {
            this.f10460j = bVar.f10470h;
            if (bVar.f10471i == null) {
                this.f10459i = new LinkedBlockingQueue(256);
            } else {
                this.f10459i = bVar.f10471i;
            }
            if (TextUtils.isEmpty(bVar.f10465c)) {
                this.f10454d = "amap-threadpool";
            } else {
                this.f10454d = bVar.f10465c;
            }
            this.f10455e = bVar.f10466d;
            this.f10456f = bVar.f10467e;
            this.f10453c = bVar.f10464b;
            this.f10451a = new AtomicLong();
            return;
        }
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }
}
