package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import java.util.UUID;

/* renamed from: com.kwad.components.core.webview.jshandler.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9155j implements InterfaceC10625a {

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.j$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9156a extends C10482a {
        public String data;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9156a c9156a = new C9156a();
        c9156a.data = UUID.randomUUID().toString();
        interfaceC10627c.mo25251a(c9156a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "uuid";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
