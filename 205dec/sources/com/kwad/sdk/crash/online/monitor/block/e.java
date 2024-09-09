package com.kwad.sdk.crash.online.monitor.block;

import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private static com.kwad.sdk.crash.online.monitor.a.a aGJ;

    public static com.kwad.sdk.crash.online.monitor.a.a HQ() {
        return aGJ;
    }

    public static boolean HR() {
        com.kwad.sdk.crash.online.monitor.a.a aVar = aGJ;
        return aVar != null && aVar.HU();
    }

    public static void d(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.HX()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "allFuncDisable");
            } else if (!a.HO()) {
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "!hasBlockMonitor");
            } else {
                a.a(aVar);
                aGJ = aVar;
                boolean bA = a.bA(true);
                com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "hasTenBlockHook:" + bA);
                if (aVar.aor < new Random().nextFloat()) {
                    return;
                }
                b.a(aVar);
                if (aVar.HV() && bA) {
                    c.b(aVar);
                }
                if (aVar.HW()) {
                    boolean bB = a.bB(false);
                    com.kwad.sdk.core.e.c.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + bB);
                }
            }
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Exception unused) {
            }
        }
    }
}
