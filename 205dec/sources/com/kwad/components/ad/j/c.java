package com.kwad.components.ad.j;

import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements h.a {
    private static volatile c HT;

    private c() {
    }

    public static c mD() {
        if (HT == null) {
            synchronized (c.class) {
                if (HT == null) {
                    HT = new c();
                }
            }
        }
        return HT;
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i4) {
        if ((fVar instanceof com.kwad.components.core.request.a) && i4 != e.awK.errorCode) {
            int i5 = 21004;
            SceneImpl scene = fVar.getScene();
            if (scene != null) {
                long posId = scene.getPosId();
                if (i4 == e.awF.errorCode) {
                    i5 = 21001;
                } else if (i4 == e.awJ.errorCode) {
                    i5 = 21003;
                } else if (i4 > 0 && i4 < 1000) {
                    i5 = 21002;
                }
                com.kwad.components.core.o.a.qI().a(posId, i5);
            }
        }
    }

    public final void init() {
        h.Ex().a(this);
    }
}
