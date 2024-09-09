package com.kwad.components.ad.reward.i;

import android.content.Context;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends bf implements bf.a {
    private PlayableSource sa;

    public b(Context context, AdTemplate adTemplate, PlayableSource playableSource) {
        super(context, adTemplate);
        this.sa = playableSource;
        a(this);
    }

    @Override // com.kwad.components.core.webview.jshandler.bf.a
    public final boolean dK() {
        com.kwad.components.ad.reward.a.eX().c(this.sa, new a(this.mContext));
        return false;
    }
}
