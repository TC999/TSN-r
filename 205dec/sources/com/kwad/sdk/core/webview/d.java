package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.webview.a.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    private long aDV;
    private boolean aDW;

    public static void d(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), aVar.nL());
        }
    }

    public final void a(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.nL());
        }
        if (aVar != null) {
            this.aDV = System.currentTimeMillis();
        }
    }

    public final void b(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.k(aVar.getAdTemplate(), System.currentTimeMillis() - this.aDV);
        }
    }

    public final void c(c.a aVar) {
        if (aVar == null || this.aDW) {
            return;
        }
        this.aDW = true;
        long j4 = 0;
        if (this.aDV > 0) {
            j4 = System.currentTimeMillis() - this.aDV;
            this.aDV = -1L;
        }
        com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.nL(), j4);
    }
}
