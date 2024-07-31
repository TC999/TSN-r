package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.ranger.p447b.p448a.C10953a;
import com.kwad.sdk.ranger.p447b.p448a.C10954b;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hy */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10129hy implements InterfaceC10273d<C10954b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10954b c10954b, JSONObject jSONObject) {
        m26830a(c10954b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10954b c10954b, JSONObject jSONObject) {
        return m26829b(c10954b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26830a(C10954b c10954b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10954b.aAL = jSONObject.optInt("func_ratio_count");
        c10954b.aNN = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("func_values");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                C10953a c10953a = new C10953a();
                c10953a.parseJson(optJSONArray.optJSONObject(i));
                c10954b.aNN.add(c10953a);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26829b(C10954b c10954b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c10954b.aAL;
        if (i != 0) {
            C11126t.putValue(jSONObject, "func_ratio_count", i);
        }
        C11126t.putValue(jSONObject, "func_values", c10954b.aNN);
        return jSONObject;
    }
}
