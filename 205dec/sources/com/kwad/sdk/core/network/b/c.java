package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    public static b Ej() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null && hVar.yJ()) {
            return new d();
        }
        return new a();
    }
}
