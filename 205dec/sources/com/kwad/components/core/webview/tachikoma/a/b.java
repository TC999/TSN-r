package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b Wf;
    private AdTemplate mAdTemplate;

    public b(@NonNull com.kwad.sdk.core.webview.b bVar, @NonNull AdTemplate adTemplate) {
        this.Wf = bVar;
        this.mAdTemplate = adTemplate;
    }

    private void aC(AdTemplate adTemplate) {
        adTemplate.mIsForceJumpLandingPage = true;
        com.kwad.components.core.e.d.a.a(new a.C0631a(this.Wf.OE.getContext()).aq(adTemplate).an(1).an(true).al(true).aq(false));
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdTemplate adTemplate = new AdTemplate();
            if (jSONObject.has("adTemplate")) {
                adTemplate.parseJson(new JSONObject(jSONObject.getString("adTemplate")));
            }
            if (adTemplate.adInfoList.size() != 0) {
                aC(adTemplate);
            } else {
                aC(this.mAdTemplate);
            }
            cVar.a(null);
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "activityMiddlePageConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
