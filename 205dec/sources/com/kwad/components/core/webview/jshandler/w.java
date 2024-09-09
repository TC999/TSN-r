package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class w implements com.kwad.sdk.core.webview.c.a {
    private List<AdTemplate> Wq;
    private com.kwad.sdk.core.webview.b cO;
    private b oD;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void N(AdTemplate adTemplate);
    }

    public w(List<AdTemplate> list) {
        this.Wq = list;
    }

    private List<AdTemplate> sn() {
        List<AdTemplate> list = this.Wq;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.cO;
        if (bVar != null) {
            return bVar.GM();
        }
        return null;
    }

    public final void a(b bVar) {
        this.oD = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate a4 = com.kwad.sdk.core.response.b.e.a(sn(), aVar.creativeId, aVar.adStyle);
            b bVar = this.oD;
            if (bVar != null) {
                bVar.N(a4);
            }
        } catch (JSONException unused) {
        }
    }

    public w(com.kwad.sdk.core.webview.b bVar) {
        this.cO = bVar;
    }
}
