package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.gd.sr;
import com.bytedance.sdk.component.gd.sr.xv;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static Executor f28683a = sr.w(new ThreadFactory() { // from class: com.bytedance.pangle.d.e.1

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f28686a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new xv(runnable, "pangle-Fast-" + this.f28686a.getAndIncrement());
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private static final Object f28684b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Handler f28685c = null;

    public static void a(Runnable runnable) {
        f28683a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    public static ExecutorService a(int i4) {
        return sr.c(i4, new ThreadFactory() { // from class: com.bytedance.pangle.d.e.2

            /* renamed from: a  reason: collision with root package name */
            private final AtomicInteger f28687a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new xv(runnable, "pangle-Install-" + this.f28687a.getAndIncrement());
            }
        });
    }

    private static Handler a() {
        Handler handler;
        synchronized (f28684b) {
            if (f28685c == null) {
                f28685c = new Handler(Looper.getMainLooper());
            }
            handler = f28685c;
        }
        return handler;
    }
}
