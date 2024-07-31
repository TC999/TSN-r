package com.kwad.sdk.ranger.p447b.p448a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.utils.C11126t;
import java.util.List;
import org.json.JSONObject;

@KsJson
/* renamed from: com.kwad.sdk.ranger.b.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10954b extends AbstractC9822a {
    public int aAL;
    public List<C10953a> aNN;

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        for (C10953a c10953a : this.aNN) {
            C11126t.putValue(jSONObject, c10953a.key, c10953a.value);
        }
        C11126t.putValue(jSONObject, "func_ratio_count", this.aAL);
        JSONObject jSONObject2 = new JSONObject();
        C11126t.putValue(jSONObject2, "ranger", jSONObject);
        return jSONObject2;
    }
}
