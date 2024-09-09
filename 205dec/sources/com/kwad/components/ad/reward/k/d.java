package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d implements com.kwad.sdk.core.webview.c.a {
    private a xe;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.b.p pVar);
    }

    public final void a(a aVar) {
        this.xe = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickCall";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.xe = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.components.core.webview.tachikoma.b.p pVar = new com.kwad.components.core.webview.tachikoma.b.p();
        try {
            pVar.parseJson(new JSONObject(str));
            a aVar = this.xe;
            if (aVar != null) {
                aVar.a(pVar);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
