package com.kwad.sdk.h;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class j {
    private static final AtomicInteger aKG = new AtomicInteger(1);
    private static final ExecutorService aKH = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.h.j.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            Thread thread = new Thread(threadGroup, runnable, "ksad-lm-thread-" + j.aKG.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    });
    private static final Handler aJC = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean I(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void JX() {
    }

    public static void JY() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(n nVar) {
        aKH.execute(nVar);
    }

    public static void ak(String str, String str2) {
        Log.d(gl(str), dX(str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static String dX(String str) {
        return str + " " + xz();
    }

    private static String gl(String str) {
        return "KSAd_LM_" + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double o(double d4) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d4)), 0, RoundingMode.HALF_UP).doubleValue();
    }

    private static String xz() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(URLConnection uRLConnection) {
        try {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
        } catch (Throwable unused) {
        }
    }
}
