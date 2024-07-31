package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9193a extends AbstractC9230w implements Observer {
    private AdTemplate mAdTemplate;

    public C9193a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9230w, com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        super.mo25241a(str, interfaceC10627c);
        m29171b(this.mAdTemplate.mAdStatusInfo);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getTrackAdStatus";
    }

    @Override // java.util.Observer
    public final void update(Observable observable, Object obj) {
        AdStatusInfo adStatusInfo = (AdStatusInfo) obj;
        if (adStatusInfo != null) {
            m29171b(adStatusInfo);
        }
    }
}
