package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.bumptech.glide.util.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Executors {

    /* renamed from: a */
    private static final Executor f14547a = new ExecutorC3767a();

    /* renamed from: b */
    private static final Executor f14548b = new ExecutorC3768b();

    /* compiled from: Executors.java */
    /* renamed from: com.bumptech.glide.util.d$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class ExecutorC3767a implements Executor {

        /* renamed from: a */
        private final Handler f14549a = new Handler(Looper.getMainLooper());

        ExecutorC3767a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f14549a.post(runnable);
        }
    }

    /* compiled from: Executors.java */
    /* renamed from: com.bumptech.glide.util.d$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class ExecutorC3768b implements Executor {
        ExecutorC3768b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    private Executors() {
    }

    /* renamed from: a */
    public static Executor m44415a() {
        return f14548b;
    }

    /* renamed from: b */
    public static Executor m44414b() {
        return f14547a;
    }

    @VisibleForTesting
    /* renamed from: c */
    public static void m44413c(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (executorService.awaitTermination(5L, timeUnit)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(5L, timeUnit)) {
                return;
            }
            throw new RuntimeException("Failed to shutdown");
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
