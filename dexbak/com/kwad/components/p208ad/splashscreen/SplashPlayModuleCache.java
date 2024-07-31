package com.kwad.components.p208ad.splashscreen;

import com.kwad.components.p208ad.splashscreen.p283e.C8478a;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* renamed from: com.kwad.components.ad.splashscreen.SplashPlayModuleCache */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SplashPlayModuleCache {

    /* renamed from: Cl */
    private HashMap<String, WeakReference<C8478a>> f27595Cl;

    /* renamed from: com.kwad.components.ad.splashscreen.SplashPlayModuleCache$Holder */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    enum Holder {
        INSTANCE;
        
        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache((byte) 0);

        Holder() {
        }

        final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    /* synthetic */ SplashPlayModuleCache(byte b) {
        this();
    }

    private SplashPlayModuleCache() {
        this.f27595Cl = new HashMap<>(1);
    }
}
