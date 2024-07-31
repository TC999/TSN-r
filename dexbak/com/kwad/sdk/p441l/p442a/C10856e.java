package com.kwad.sdk.p441l.p442a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.l.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10856e extends C10482a implements InterfaceC9914b {
    public int sensorType = -1;
    public List<Float> aNc = new ArrayList();
    public long timestamp = 0;

    /* renamed from: a */
    private void m24629a(C10856e c10856e, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10856e.sensorType = jSONObject.optInt("sensorType");
        c10856e.timestamp = jSONObject.optLong(CampaignEx.JSON_KEY_TIMESTAMP);
        super.afterToJson(jSONObject);
    }

    /* renamed from: b */
    private static JSONObject m24628b(C10856e c10856e, JSONObject jSONObject) {
        C11126t.putValue(jSONObject, "sensorType", c10856e.sensorType);
        C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, c10856e.timestamp);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a
    public final void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        C11126t.putValue(jSONObject, "values", this.aNc);
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        m24629a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject m24628b = m24628b(this, new JSONObject());
        afterToJson(m24628b);
        return m24628b;
    }
}
