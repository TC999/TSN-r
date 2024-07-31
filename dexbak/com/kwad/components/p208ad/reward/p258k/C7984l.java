package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.C9046ad;
import com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.k.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7984l extends AbstractC9230w {
    /* renamed from: g */
    public final void m31906g(@NonNull List<AdTemplate> list) {
        AdResultData adResultData = new AdResultData();
        adResultData.setAdTemplateList(list);
        m29171b(new C9046ad.C9052a(adResultData));
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerAggregationDataListener";
    }
}
