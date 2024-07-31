package com.kwad.sdk.core.webview.p423d.p425b;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11053bg;
import org.json.JSONException;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.sdk.core.webview.d.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10640a extends C10482a {

    /* renamed from: KS */
    public String f29641KS;

    /* renamed from: Kr */
    public boolean f29642Kr;
    @Deprecated

    /* renamed from: XA */
    public boolean f29643XA;

    /* renamed from: XC */
    public int f29644XC;

    /* renamed from: XD */
    public C10642c f29645XD;
    public int aEL;
    public int aEM;
    public AdTemplate adTemplate;

    /* renamed from: kl */
    public int f29646kl;

    /* renamed from: KE */
    public boolean f29640KE = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean aEN = false;
    public boolean aEO = false;

    /* renamed from: Hb */
    public final boolean m25240Hb() {
        return 1 == this.f29644XC;
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.f29646kl == 0 && this.aEM == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("logParam");
                    this.f29646kl = optJSONObject.getInt("itemClickType");
                    this.aEM = optJSONObject.getInt("sceneType");
                    this.aEN = optJSONObject.optBoolean("isCallbackOnly");
                }
                String optString = jSONObject.optString("adTemplate");
                if (C11053bg.isNullString(optString)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    AdTemplate adTemplate = new AdTemplate();
                    this.adTemplate = adTemplate;
                    adTemplate.parseJson(jSONObject2);
                } catch (JSONException e) {
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
