package com.kwad.sdk.core.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.report.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10443a extends C10482a {
    public String axl;

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            this.axl = jSONObject.optString("adTrackLog");
        }
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        C11126t.putValue(jSONObject, "adTrackLog", this.axl);
    }
}
