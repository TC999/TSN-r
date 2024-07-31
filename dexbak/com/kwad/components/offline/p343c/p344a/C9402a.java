package com.kwad.components.offline.p343c.p344a;

import com.kwad.components.offline.api.p341tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.webview.p422c.C10629e;
import com.kwad.sdk.core.webview.p422c.C10630f;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.offline.c.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9402a implements InterfaceC10627c {
    private final IOfflineCompoCallBackFunction adh;

    public C9402a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.adh = iOfflineCompoCallBackFunction;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10627c
    /* renamed from: a */
    public final void mo25251a(InterfaceC9914b interfaceC9914b) {
        String jSONObject = new C10630f(interfaceC9914b).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.adh;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onSuccess(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10627c
    public final void onError(int i, String str) {
        String jSONObject = new C10629e(i, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.adh;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(jSONObject);
        }
    }
}
