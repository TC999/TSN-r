package com.kwad.sdk.utils.p450a;

import com.kwad.sdk.utils.p450a.C10990c;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.sdk.utils.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10998d {
    static C10990c.InterfaceC10996d aRZ;
    static volatile Executor aSa;
    static ExecutorService aSb = Executors.newSingleThreadExecutor();

    private C10998d() {
    }

    /* renamed from: a */
    public static void m24178a(C10990c.InterfaceC10996d interfaceC10996d) {
        aRZ = interfaceC10996d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor getExecutor() {
        if (aSa == null) {
            synchronized (C10998d.class) {
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
