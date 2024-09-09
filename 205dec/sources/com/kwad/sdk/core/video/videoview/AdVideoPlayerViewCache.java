package com.kwad.sdk.core.video.videoview;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class AdVideoPlayerViewCache {
    private HashMap<String, WeakReference<a>> Cl;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    enum Holder {
        INSTANCE;
        
        private AdVideoPlayerViewCache mInstance = new AdVideoPlayerViewCache((byte) 0);

        Holder() {
        }

        final AdVideoPlayerViewCache getInstance() {
            return this.mInstance;
        }
    }

    /* synthetic */ AdVideoPlayerViewCache(byte b4) {
        this();
    }

    public static AdVideoPlayerViewCache getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(String str, a aVar) {
        this.Cl.put(str, new WeakReference<>(aVar));
    }

    public final a ew(String str) {
        WeakReference<a> weakReference = this.Cl.get(str);
        if (weakReference != null) {
            a aVar = weakReference.get();
            if (aVar != null) {
                return aVar;
            }
            this.Cl.remove(str);
        }
        return null;
    }

    public final void remove(String str) {
        this.Cl.remove(str);
    }

    private AdVideoPlayerViewCache() {
        this.Cl = new HashMap<>(1);
    }
}
