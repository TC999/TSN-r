package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.tachikoma.a.w;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class o extends w implements aq.b {
    @Nullable
    private com.kwad.components.core.playable.a oL;

    public o(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar = gVar.oL;
        this.oL = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.aq.b
    public final void a(aq.a aVar) {
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerPlayableStatusListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        super.onDestroy();
        com.kwad.components.core.playable.a aVar = this.oL;
        if (aVar != null) {
            aVar.b(this);
            this.oL = null;
        }
    }
}
