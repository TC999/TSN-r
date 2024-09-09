package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class GlobalImageListener implements OnRenderResultListener<AdTemplate> {
    @Override // com.kwad.sdk.core.imageloader.OnRenderResultListener
    public void onRenderResult(boolean z3, AdTemplate adTemplate, String str, String str2) {
        if (!z3) {
            ((b) ServiceProvider.get(b.class)).H(str, str2);
        }
        if (z3) {
            return;
        }
        ((b) ServiceProvider.get(b.class)).aE(adTemplate);
    }
}
