package com.kwad.sdk.service;

import com.kwad.sdk.service.a.e;
import com.kwad.sdk.service.a.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    public static void G(String str, String str2) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.G(str, str2);
        }
    }

    public static void a(g gVar) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.a(gVar);
        }
    }

    public static void b(com.kwad.sdk.service.a.c cVar) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.a(cVar);
        }
    }

    public static void gatherException(Throwable th) {
        e eVar = (e) ServiceProvider.get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        }
    }
}
