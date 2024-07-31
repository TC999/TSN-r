package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.ad.reward.k.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7966b implements InterfaceC10625a {

    /* renamed from: xc */
    private InterfaceC7967a f26682xc;

    /* renamed from: com.kwad.components.ad.reward.k.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7967a {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        mo31342iX();
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenFinish";
    }

    /* renamed from: iX */
    public void mo31342iX() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f26682xc = null;
    }
}
