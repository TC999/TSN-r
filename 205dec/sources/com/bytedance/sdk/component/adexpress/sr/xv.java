package com.bytedance.sdk.component.adexpress.sr;

import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static void c(p pVar, int i4) {
        if (pVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.c.c.xv xv = com.bytedance.sdk.component.adexpress.c.c.c.c().xv();
        ExecutorService ys = xv != null ? xv.ys() : null;
        if (ys != null) {
            pVar.c(i4);
            ys.execute(pVar);
            return;
        }
        ev.c(pVar, i4);
    }

    public static void w(p pVar, int i4) {
        if (pVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.c.c.xv xv = com.bytedance.sdk.component.adexpress.c.c.c.c().xv();
        ExecutorService t3 = xv != null ? xv.t() : null;
        if (t3 != null) {
            pVar.c(i4);
            t3.execute(pVar);
            return;
        }
        ev.c(pVar);
    }

    public static ScheduledFuture c(Runnable runnable, long j4, TimeUnit timeUnit) {
        return ev.sr().schedule(runnable, j4, timeUnit);
    }
}
