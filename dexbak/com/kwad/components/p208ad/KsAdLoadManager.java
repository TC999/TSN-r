package com.kwad.components.p208ad;

import androidx.annotation.NonNull;
import com.kwad.components.core.p287c.C8548d;
import com.kwad.components.core.p287c.C8554g;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.p208ad.adbit.C7334c;
import java.util.List;

/* renamed from: com.kwad.components.ad.KsAdLoadManager */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class KsAdLoadManager {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.KsAdLoadManager$Holder */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public enum Holder {
        INSTANCE;
        
        private final KsAdLoadManager mInstance = new KsAdLoadManager((byte) 0);

        Holder() {
        }
    }

    /* synthetic */ KsAdLoadManager(byte b) {
        this();
    }

    /* renamed from: M */
    public static KsAdLoadManager m33469M() {
        return Holder.INSTANCE.mInstance;
    }

    /* renamed from: a */
    public static void m33468a(@NonNull C8927a c8927a) {
        if (C7334c.m33455b(c8927a)) {
            return;
        }
        C8548d.m30390mx().m30391c(c8927a);
    }

    /* renamed from: b */
    public final synchronized <T> void m33466b(List<T> list) {
        for (T t : list) {
            C8554g.m30373mF().add(t);
        }
    }

    private KsAdLoadManager() {
    }

    /* renamed from: a */
    public final synchronized <T> void m33467a(T t) {
        C8554g.m30373mF().add(t);
    }
}
