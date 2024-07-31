package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10964b;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class GlobalImageListener implements OnRenderResultListener<AdTemplate> {
    @Override // com.kwad.sdk.core.imageloader.OnRenderResultListener
    public void onRenderResult(boolean z, AdTemplate adTemplate, String str, String str2) {
        if (!z) {
            ((InterfaceC10964b) ServiceProvider.get(InterfaceC10964b.class)).mo24353H(str, str2);
        }
        if (z) {
            return;
        }
        ((InterfaceC10964b) ServiceProvider.get(InterfaceC10964b.class)).mo24352aE(adTemplate);
    }
}
