package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.ranger.p447b.p448a.C10955c;
import com.kwad.sdk.ranger.p447b.p448a.C10956d;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jp */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10174jp implements InterfaceC10273d<C10956d> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10956d c10956d, JSONObject jSONObject) {
        m26740a(c10956d, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10956d c10956d, JSONObject jSONObject) {
        return m26739b(c10956d, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26740a(C10956d c10956d, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10956d.aNP = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("ranger");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                C10955c c10955c = new C10955c();
                c10955c.parseJson(optJSONArray.optJSONObject(i));
                c10956d.aNP.add(c10955c);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26739b(C10956d c10956d, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "ranger", c10956d.aNP);
        return jSONObject;
    }
}
