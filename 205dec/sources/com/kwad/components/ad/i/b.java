package com.kwad.components.ad.i;

import com.kwad.components.core.proxy.i;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b implements h.a {
    private static volatile b Hr;

    /* renamed from: com.kwad.components.ad.i.b$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass1 extends i {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.core.c.c
        /* renamed from: a */
        public final void d(com.kwad.components.core.proxy.c cVar) {
            super.d(cVar);
            b.a(b.this).put(cVar, b.eM());
        }

        @Override // com.kwad.components.core.proxy.i, com.kwad.sdk.core.c.c
        /* renamed from: b */
        public final void c(com.kwad.components.core.proxy.c cVar) {
            super.c(cVar);
            b.a(b.this).remove(cVar);
            if (b.a(b.this).isEmpty()) {
                b.b(b.this);
            }
        }
    }

    private b() {
    }

    public static b md() {
        if (Hr == null) {
            synchronized (b.class) {
                if (Hr == null) {
                    Hr = new b();
                }
            }
        }
        return Hr;
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i4) {
        if ((fVar instanceof com.kwad.components.core.request.a) && i4 != com.kwad.sdk.core.network.e.avy.errorCode) {
            int i5 = 21004;
            SceneImpl scene = fVar.getScene();
            if (scene != null) {
                long posId = scene.getPosId();
                if (i4 == com.kwad.sdk.core.network.e.avt.errorCode) {
                    i5 = 21001;
                } else if (i4 == com.kwad.sdk.core.network.e.avx.errorCode) {
                    i5 = 21003;
                } else if (i4 > 0 && i4 < 1000) {
                    i5 = 21002;
                }
                com.kwad.components.core.o.a.qi().a(posId, i5);
            }
        }
    }

    public final void init() {
        h.DN().a(this);
    }
}
