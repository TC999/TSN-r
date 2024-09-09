package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Observable;
import java.util.Observer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends w implements Observer {
    private AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        super.a(str, cVar);
        b(this.mAdTemplate.mAdStatusInfo);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getTrackAdStatus";
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        AdStatusInfo adStatusInfo = (AdStatusInfo) obj;
        if (adStatusInfo != null) {
            b(adStatusInfo);
        }
    }
}