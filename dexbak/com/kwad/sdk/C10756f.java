package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.framework.p346a.C9425a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.p404a.C10407c;
import com.kwad.sdk.core.network.p406c.C10416a;
import com.kwad.sdk.core.network.p406c.C10417b;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* renamed from: com.kwad.sdk.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10756f {
    private static AdHttpProxy akE;

    @NonNull
    /* renamed from: xT */
    public static AdHttpProxy m24902xT() {
        AdHttpProxy adHttpProxy = akE;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (C9425a.f29473md.booleanValue()) {
            return m24901xU();
        }
        try {
            if (C10407c.m26166DS() != null) {
                akE = new C10417b();
            } else {
                akE = new C10416a();
            }
        } catch (Throwable unused) {
            akE = new C10416a();
        }
        return akE;
    }

    /* renamed from: xU */
    private static AdHttpProxy m24901xU() {
        C9861c.m27501f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new C10417b() : new C10416a();
    }
}
