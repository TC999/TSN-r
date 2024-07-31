package com.kwad.sdk.crash.online.monitor.block;

import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.online.monitor.p428a.C10696a;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* renamed from: com.kwad.sdk.crash.online.monitor.block.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10706e {
    private static C10696a aGJ;

    /* renamed from: HQ */
    public static C10696a m25079HQ() {
        return aGJ;
    }

    /* renamed from: HR */
    public static boolean m25078HR() {
        C10696a c10696a = aGJ;
        return c10696a != null && c10696a.m25100HU();
    }

    /* renamed from: d */
    public static void m25077d(C10696a c10696a) {
        if (c10696a == null) {
            return;
        }
        try {
            if (c10696a.m25097HX()) {
                C10331c.m26254d("perfMonitor.BlockManager", "allFuncDisable");
            } else if (!C10700a.m25095HO()) {
                C10331c.m26254d("perfMonitor.BlockManager", "!hasBlockMonitor");
            } else {
                C10700a.m25093a(c10696a);
                aGJ = c10696a;
                boolean m25091bA = C10700a.m25091bA(true);
                C10331c.m26254d("perfMonitor.BlockManager", "hasTenBlockHook:" + m25091bA);
                if (c10696a.aor < new Random().nextFloat()) {
                    return;
                }
                C10702b.m25088a(c10696a);
                if (c10696a.m25099HV() && m25091bA) {
                    C10703c.m25083b(c10696a);
                }
                if (c10696a.m25098HW()) {
                    boolean m25090bB = C10700a.m25090bB(false);
                    C10331c.m26254d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + m25090bB);
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
