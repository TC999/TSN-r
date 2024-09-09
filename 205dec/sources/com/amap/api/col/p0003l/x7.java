package com.amap.api.col.p0003l;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: WiFiUplateStrategy.java */
/* renamed from: com.amap.api.col.3l.x7  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x7 extends w7 {

    /* renamed from: b  reason: collision with root package name */
    private Context f9431b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9432c;

    /* compiled from: BasicThreadFactory.java */
    /* renamed from: com.amap.api.col.3l.x7$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f9433a;

        a(Runnable runnable) {
            this.f9433a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f9433a.run();
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: BasicThreadFactory.java */
    /* renamed from: com.amap.api.col.3l.x7$b */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private ThreadFactory f9435a;

        /* renamed from: b  reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f9436b;

        /* renamed from: c  reason: collision with root package name */
        private String f9437c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f9438d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f9439e;

        /* renamed from: f  reason: collision with root package name */
        private int f9440f = x7.e();

        /* renamed from: g  reason: collision with root package name */
        private int f9441g = x7.f();

        /* renamed from: h  reason: collision with root package name */
        private int f9442h = 30;

        /* renamed from: i  reason: collision with root package name */
        private BlockingQueue<Runnable> f9443i;

        private void j() {
            this.f9435a = null;
            this.f9436b = null;
            this.f9437c = null;
            this.f9438d = null;
            this.f9439e = null;
        }

        public final b a() {
            this.f9440f = 1;
            return this;
        }

        public final b b(int i4) {
            if (this.f9440f > 0) {
                this.f9441g = i4;
                return this;
            }
            throw new NullPointerException("corePoolSize  must > 0!");
        }

        public final b c(String str) {
            if (str != null) {
                this.f9437c = str;
                return this;
            }
            throw new NullPointerException("Naming pattern must not be null!");
        }

        public final b d(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            if (uncaughtExceptionHandler != null) {
                this.f9436b = uncaughtExceptionHandler;
                return this;
            }
            throw new NullPointerException("Uncaught exception handler must not be null!");
        }

        public final b e(BlockingQueue<Runnable> blockingQueue) {
            this.f9443i = blockingQueue;
            return this;
        }

        public final x7 h() {
            x7 x7Var = new x7(this, (byte) 0);
            j();
            return x7Var;
        }
    }

    public x7(Context context, boolean z3) {
        this.f9431b = context;
        this.f9432c = z3;
    }

    @Override // com.amap.api.col.p0003l.w7
    protected final boolean d() {
        return i4.M(this.f9431b) == 1 || this.f9432c;
    }
}
