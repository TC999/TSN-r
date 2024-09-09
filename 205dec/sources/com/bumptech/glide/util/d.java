package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Executors.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f18065a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f18066b = new b();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Executors.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f18067a = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f18067a.post(runnable);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Executors.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    }

    private d() {
    }

    public static Executor a() {
        return f18066b;
    }

    public static Executor b() {
        return f18065a;
    }

    @VisibleForTesting
    public static void c(ExecutorService executorService) {
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
        } catch (InterruptedException e4) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e4);
        }
    }
}
