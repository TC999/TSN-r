package com.kwad.components.core.e.e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends Presenter {
    protected c Lq;
    protected AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    public void aj() {
        super.aj();
        c cVar = (c) Jx();
        this.Lq = cVar;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.dQ(cVar.Lp.getAdTemplate());
    }
}
