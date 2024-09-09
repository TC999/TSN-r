package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class SplashPlayModuleCache {
    private HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.e.a>> Cl;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    enum Holder {
        INSTANCE;
        
        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache((byte) 0);

        Holder() {
        }

        final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    /* synthetic */ SplashPlayModuleCache(byte b4) {
        this();
    }

    private SplashPlayModuleCache() {
        this.Cl = new HashMap<>(1);
    }
}
