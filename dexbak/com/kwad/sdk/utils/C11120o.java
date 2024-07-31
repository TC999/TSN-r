package com.kwad.sdk.utils;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10964b;
import com.kwad.sdk.service.p449a.InterfaceC10970h;

/* renamed from: com.kwad.sdk.utils.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11120o {
    private static boolean aOJ;
    private static boolean aOK;

    /* renamed from: Li */
    public static boolean m23762Li() {
        return (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(2L)) & aOJ;
    }

    /* renamed from: Lj */
    public static boolean m23761Lj() {
        return (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(4L)) & aOJ;
    }

    /* renamed from: Lk */
    public static boolean m23760Lk() {
        return (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(2048L)) & aOJ;
    }

    /* renamed from: Ll */
    public static boolean m23759Ll() {
        return ((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24322yB() && aOJ;
    }

    /* renamed from: Lm */
    public static boolean m23758Lm() {
        return (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(16L)) & aOJ;
    }

    /* renamed from: Ln */
    public static boolean m23757Ln() {
        return (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(4096L)) & aOJ;
    }

    /* renamed from: Lo */
    public static boolean m23756Lo() {
        return (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(1L)) & aOJ;
    }

    /* renamed from: Lp */
    public static boolean m23755Lp() {
        return (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(128L)) & aOJ;
    }

    /* renamed from: Lq */
    public static boolean m23754Lq() {
        return (!((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(128L)) & aOJ;
    }

    /* renamed from: bR */
    public static synchronized void m23753bR(boolean z) {
        synchronized (C11120o.class) {
            if (aOK) {
                return;
            }
            aOK = true;
            aOJ = true;
            ((InterfaceC10964b) ServiceProvider.get(InterfaceC10964b.class)).mo24350yl();
        }
    }
}
