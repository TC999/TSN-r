package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class d implements com.kwad.sdk.core.webview.c.a {
    public abstract void a(com.kwad.components.core.webview.tachikoma.b.g gVar);

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.g gVar = new com.kwad.components.core.webview.tachikoma.b.g();
        try {
            gVar.parseJson(new JSONObject(str));
            a(gVar);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "commonLog";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
