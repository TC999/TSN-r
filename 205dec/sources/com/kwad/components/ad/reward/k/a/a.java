package com.kwad.components.ad.reward.k.a;

import com.kwad.components.ad.reward.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.components.core.webview.tachikoma.c.b {
    private g xq;

    public a(g gVar) {
        this.xq = gVar;
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.gL().a(this.mAdTemplate, bVar);
    }

    public final g ji() {
        return this.xq;
    }

    @Override // com.kwad.components.core.webview.tachikoma.c.b, com.kwad.sdk.mvp.a
    public final void release() {
        super.release();
        this.xq = null;
    }
}
