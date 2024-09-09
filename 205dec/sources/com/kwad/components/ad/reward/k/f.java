package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class f implements com.kwad.sdk.core.webview.c.a {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean xi;
    }

    public void U(boolean z3) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        bn.postOnUiThread(new ay() { // from class: com.kwad.components.ad.reward.k.f.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                boolean z3;
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    z3 = aVar.xi;
                } catch (Exception unused) {
                    z3 = false;
                }
                f.this.U(z3);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
