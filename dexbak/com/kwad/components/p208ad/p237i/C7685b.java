package com.kwad.components.p208ad.p237i;

import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.request.C8910a;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.network.C10422h;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.internal.api.SceneImpl;

/* renamed from: com.kwad.components.ad.i.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7685b implements C10422h.InterfaceC10423a {

    /* renamed from: Hr */
    private static volatile C7685b f26027Hr;

    private C7685b() {
    }

    /* renamed from: md */
    public static C7685b m32650md() {
        if (f26027Hr == null) {
            synchronized (C7685b.class) {
                if (f26027Hr == null) {
                    f26027Hr = new C7685b();
                }
            }
        }
        return f26027Hr;
    }

    @Override // com.kwad.sdk.core.network.C10422h.InterfaceC10423a
    /* renamed from: a */
    public final void mo26108a(InterfaceC10420f interfaceC10420f, int i) {
        if ((interfaceC10420f instanceof C8910a) && i != C10419e.avy.errorCode) {
            int i2 = 21004;
            SceneImpl scene = interfaceC10420f.getScene();
            if (scene != null) {
                long posId = scene.getPosId();
                if (i == C10419e.avt.errorCode) {
                    i2 = 21001;
                } else if (i == C10419e.avx.errorCode) {
                    i2 = 21003;
                } else if (i > 0 && i < 1000) {
                    i2 = 21002;
                }
                C8766a.m29888qi().m29917a(posId, i2);
            }
        }
    }

    public final void init() {
        C10422h.m26111DN().m26110a(this);
    }
}
