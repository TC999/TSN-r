package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class z implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            WebViewCommercialMsg webViewCommercialMsg = new WebViewCommercialMsg();
            webViewCommercialMsg.parseJson(new JSONObject(str));
            a(webViewCommercialMsg);
            cVar.a(null);
        } catch (JSONException e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            cVar.onError(-1, e4.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "commercialLog";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    private static void a(@NonNull WebViewCommercialMsg webViewCommercialMsg) {
        com.kwad.sdk.core.e.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + webViewCommercialMsg.category);
        com.kwad.sdk.commercial.b.a(webViewCommercialMsg.category, webViewCommercialMsg);
    }
}
