package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.z */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9191z implements InterfaceC10625a {
    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            WebViewCommercialMsg webViewCommercialMsg = new WebViewCommercialMsg();
            webViewCommercialMsg.parseJson(new JSONObject(str));
            m29191a(webViewCommercialMsg);
            interfaceC10627c.mo25251a(null);
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
            interfaceC10627c.onError(-1, e.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "commercialLog";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }

    /* renamed from: a */
    private static void m29191a(@NonNull WebViewCommercialMsg webViewCommercialMsg) {
        C10331c.m26254d("WebCardLogHandler", "handleH5Log actionType actionType" + webViewCommercialMsg.category);
        C9815b.m27690a(webViewCommercialMsg.category, webViewCommercialMsg);
    }
}
