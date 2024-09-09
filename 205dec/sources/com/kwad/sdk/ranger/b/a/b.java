package com.kwad.sdk.ranger.b.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONObject;

@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int aAL;
    public List<a> aNN;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (a aVar : this.aNN) {
            t.putValue(jSONObject, aVar.key, aVar.value);
        }
        t.putValue(jSONObject, "func_ratio_count", this.aAL);
        JSONObject jSONObject2 = new JSONObject();
        t.putValue(jSONObject2, "ranger", jSONObject);
        return jSONObject2;
    }
}
