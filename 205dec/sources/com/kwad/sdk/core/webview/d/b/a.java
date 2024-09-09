package com.kwad.sdk.core.webview.d.b;

import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.sdk.core.response.a.a {
    public String KS;
    public boolean Kr;
    @Deprecated
    public boolean XA;
    public int XC;
    public c XD;
    public int aEL;
    public int aEM;
    public AdTemplate adTemplate;
    public int kl;
    public boolean KE = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean aEN = false;
    public boolean aEO = false;

    public final boolean Hb() {
        return 1 == this.XC;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.kl == 0 && this.aEM == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("logParam");
                    this.kl = optJSONObject.getInt("itemClickType");
                    this.aEM = optJSONObject.getInt("sceneType");
                    this.aEN = optJSONObject.optBoolean("isCallbackOnly");
                }
                String optString = jSONObject.optString("adTemplate");
                if (bg.isNullString(optString)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    AdTemplate adTemplate = new AdTemplate();
                    this.adTemplate = adTemplate;
                    adTemplate.parseJson(jSONObject2);
                } catch (JSONException e4) {
                    ServiceProvider.reportSdkCaughtException(e4);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
