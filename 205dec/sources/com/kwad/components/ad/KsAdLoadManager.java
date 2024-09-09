package com.kwad.components.ad;

import androidx.annotation.NonNull;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.c.d;
import com.kwad.components.core.c.g;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class KsAdLoadManager {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public enum Holder {
        INSTANCE;
        
        private final KsAdLoadManager mInstance = new KsAdLoadManager((byte) 0);

        Holder() {
        }
    }

    /* synthetic */ KsAdLoadManager(byte b4) {
        this();
    }

    public static KsAdLoadManager M() {
        return Holder.INSTANCE.mInstance;
    }

    public static void a(@NonNull com.kwad.components.core.request.model.a aVar) {
        if (c.b(aVar)) {
            return;
        }
        d.mx().c(aVar);
    }

    public final synchronized <T> void b(List<T> list) {
        for (T t3 : list) {
            g.mF().add(t3);
        }
    }

    private KsAdLoadManager() {
    }

    public final synchronized <T> void a(T t3) {
        g.mF().add(t3);
    }
}
