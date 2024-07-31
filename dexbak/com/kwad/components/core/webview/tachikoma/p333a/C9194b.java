package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9194b implements InterfaceC10625a {

    /* renamed from: Wf */
    protected final C10605b f29288Wf;
    private AdTemplate mAdTemplate;

    public C9194b(@NonNull C10605b c10605b, @NonNull AdTemplate adTemplate) {
        this.f29288Wf = c10605b;
        this.mAdTemplate = adTemplate;
    }

    /* renamed from: aC */
    private void m29190aC(AdTemplate adTemplate) {
        adTemplate.mIsForceJumpLandingPage = true;
        C8615a.m30233a(new C8615a.C8616a(this.f29288Wf.f29621OE.getContext()).m30198aq(adTemplate).m30205an(1).m30204an(true).m30208al(true).m30197aq(false));
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AdTemplate adTemplate = new AdTemplate();
            if (jSONObject.has("adTemplate")) {
                adTemplate.parseJson(new JSONObject(jSONObject.getString("adTemplate")));
            }
            if (adTemplate.adInfoList.size() != 0) {
                m29190aC(adTemplate);
            } else {
                m29190aC(this.mAdTemplate);
            }
            interfaceC10627c.mo25251a(null);
        } catch (Exception e) {
            C10331c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "activityMiddlePageConvert";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
