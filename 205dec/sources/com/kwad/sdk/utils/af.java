package com.kwad.sdk.utils;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class af {
    private Map<String, com.kwad.sdk.core.webview.a> aPr;
    private Map<String, com.kwad.sdk.core.webview.c.c> aPs;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.aPr.put(str, aVar);
    }

    public final void b(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aPs.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.a gA(String str) {
        return this.aPr.get(str);
    }

    public final com.kwad.sdk.core.webview.c.c gB(String str) {
        return this.aPs.get(str);
    }

    public final void release() {
        for (com.kwad.sdk.core.webview.a aVar : this.aPr.values()) {
            aVar.ok();
        }
        this.aPr.clear();
        this.aPs.clear();
    }
}
