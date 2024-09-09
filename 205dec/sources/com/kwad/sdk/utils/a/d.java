package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    static c.d aRZ;
    static volatile Executor aSa;
    static ExecutorService aSb = Executors.newSingleThreadExecutor();

    private d() {
    }

    public static void a(c.d dVar) {
        aRZ = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor getExecutor() {
        if (aSa == null) {
            synchronized (d.class) {
                if (aSa == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    aSa = threadPoolExecutor;
                }
            }
        }
        return aSa;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            aSa = executor;
        }
    }
}
