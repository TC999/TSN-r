package com.kwad.sdk.k.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class e extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int sensorType = -1;
    public List<Float> aOj = new ArrayList();
    public long timestamp = 0;

    private void a(e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.sensorType = jSONObject.optInt("sensorType");
        eVar.timestamp = jSONObject.optLong(CampaignEx.JSON_KEY_TIMESTAMP);
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(e eVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "sensorType", eVar.sensorType);
        t.putValue(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, eVar.timestamp);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public final void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.putValue(jSONObject, "values", this.aOj);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b4 = b(this, new JSONObject());
        afterToJson(b4);
        return b4;
    }
}
