package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.kwad.sdk.utils.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C11095g {
    private static volatile Executor aOv;
    private static volatile ScheduledExecutorService aOw;

    public static void execute(Runnable runnable) {
        if (aOv == null) {
            synchronized (C11095g.class) {
                if (aOv == null) {
                    aOv = GlobalThreadPools.m25598FK();
                }
            }
        }
        aOv.execute(runnable);
    }

    public static void schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        if (aOw == null) {
            synchronized (C11095g.class) {
                if (aOw == null) {
                    aOw = GlobalThreadPools.m25597FL();
                }
            }
        }
        aOw.schedule(runnable, j, timeUnit);
    }
}
