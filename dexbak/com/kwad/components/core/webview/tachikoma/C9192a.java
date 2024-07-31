package com.kwad.components.core.webview.tachikoma;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9251l;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.tachikoma.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9192a implements InterfaceC10625a {
    private final AdTemplate mAdTemplate;

    public C9192a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            String m25943aS = C10483a.m25943aS(C10487e.m25641dQ(adTemplate));
            if (TextUtils.isEmpty(m25943aS)) {
                interfaceC10627c.onError(-1, "landing page url is null");
                return;
            }
            C9251l c9251l = new C9251l();
            c9251l.aan = m25943aS;
            interfaceC10627c.mo25251a(c9251l);
            return;
        }
        interfaceC10627c.onError(-1, "adTemplate is null");
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getLandingPageInfo";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
