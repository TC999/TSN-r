package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class s implements com.kwad.sdk.core.webview.c.a {
    private a ZP;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(com.kwad.components.core.webview.tachikoma.b.s sVar);
    }

    public final void a(a aVar) {
        this.ZP = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "showToast";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.ZP = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (this.ZP != null) {
            com.kwad.components.core.webview.tachikoma.b.s sVar = new com.kwad.components.core.webview.tachikoma.b.s();
            try {
                sVar.parseJson(new JSONObject(str));
                this.ZP.a(sVar);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }
}
