package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.b.l;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private final AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            String aS = com.kwad.sdk.core.response.b.a.aS(com.kwad.sdk.core.response.b.e.dQ(adTemplate));
            if (TextUtils.isEmpty(aS)) {
                cVar.onError(-1, "landing page url is null");
                return;
            }
            l lVar = new l();
            lVar.aan = aS;
            cVar.a(lVar);
            return;
        }
        cVar.onError(-1, "adTemplate is null");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getLandingPageInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
