package com.kwad.components.core.webview.tachikoma;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.webview.tachikoma.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9287e implements InterfaceC10625a {

    /* renamed from: ns */
    private InterfaceC10627c f29338ns;

    /* renamed from: b */
    public final void m29103b(final C10482a c10482a) {
        if (this.f29338ns != null) {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.e.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C9287e.this.f29338ns.mo25251a(c10482a);
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerConvertStatusListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29338ns = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29338ns = interfaceC10627c;
    }
}
