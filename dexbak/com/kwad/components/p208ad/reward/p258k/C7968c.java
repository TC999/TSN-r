package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.ad.reward.k.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7968c implements InterfaceC10625a {

    /* renamed from: xd */
    private InterfaceC7969a f26683xd;

    /* renamed from: com.kwad.components.ad.reward.k.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7969a {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        mo31344iX();
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "callButtonImpressionWhenPlay";
    }

    /* renamed from: iX */
    public void mo31344iX() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f26683xd = null;
    }
}
