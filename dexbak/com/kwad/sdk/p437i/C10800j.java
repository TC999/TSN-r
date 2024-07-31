package com.kwad.sdk.p437i;

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

/* renamed from: com.kwad.sdk.i.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C10800j {
    private static final AtomicInteger aJr = new AtomicInteger(1);
    private static final ExecutorService aJs = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.i.j.1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            Thread thread = new Thread(threadGroup, runnable, "ksad-lm-thread-" + C10800j.aJr.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    });
    private static final Handler aIn = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: I */
    public static boolean m24814I(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Jm */
    public static void m24813Jm() {
    }

    /* renamed from: Jn */
    public static void m24812Jn() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m24810a(AbstractRunnableC10807n abstractRunnableC10807n) {
        aJs.execute(abstractRunnableC10807n);
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

    /* renamed from: dN */
    private static String m24808dN(String str) {
        return str + " " + m24805wV();
    }

    /* renamed from: fY */
    private static String m24807fY(String str) {
        return "KSAd_LM_" + str;
    }

    public static void logE(String str, String str2) {
        Log.d(m24807fY(str), m24808dN(str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static double m24806o(double d) {
        return new BigDecimal(Double.toString(1.0d)).divide(new BigDecimal(Double.toString(d)), 0, RoundingMode.HALF_UP).doubleValue();
    }

    /* renamed from: wV */
    private static String m24805wV() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m24809a(URLConnection uRLConnection) {
        try {
            if (uRLConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnection).disconnect();
            }
        } catch (Throwable unused) {
        }
    }
}
