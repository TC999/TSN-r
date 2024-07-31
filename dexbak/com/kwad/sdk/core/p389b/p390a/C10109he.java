package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.p435h.p436a.C10771a;
import com.kwad.sdk.p435h.p436a.C10772b;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.he */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10109he implements InterfaceC10273d<C10771a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10771a c10771a, JSONObject jSONObject) {
        m26870a(c10771a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10771a c10771a, JSONObject jSONObject) {
        return m26869b(c10771a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26870a(C10771a c10771a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10771a.sceneId = jSONObject.optString("sceneId");
        if (JSONObject.NULL.toString().equals(c10771a.sceneId)) {
            c10771a.sceneId = "";
        }
        c10771a.aHW = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("packages");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                C10772b c10772b = new C10772b();
                c10772b.parseJson(optJSONArray.optJSONObject(i));
                c10771a.aHW.add(c10772b);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26869b(C10771a c10771a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10771a.sceneId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "sceneId", c10771a.sceneId);
        }
        C11126t.putValue(jSONObject, "packages", c10771a.aHW);
        return jSONObject;
    }
}
