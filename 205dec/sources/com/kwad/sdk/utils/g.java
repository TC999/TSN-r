package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g {
    private static volatile Executor aOv;
    private static volatile ScheduledExecutorService aOw;

    public static void execute(Runnable runnable) {
        if (aOv == null) {
            synchronized (g.class) {
                if (aOv == null) {
                    aOv = GlobalThreadPools.FK();
                }
            }
        }
        aOv.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j4, TimeUnit timeUnit) {
        if (aOw == null) {
            synchronized (g.class) {
                if (aOw == null) {
                    aOw = GlobalThreadPools.FL();
                }
            }
        }
        aOw.schedule(runnable, j4, timeUnit);
    }
}
