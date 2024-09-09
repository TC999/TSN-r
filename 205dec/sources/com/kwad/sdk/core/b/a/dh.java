package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class dh implements com.kwad.sdk.core.d<a.C0714a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0714a c0714a, JSONObject jSONObject) {
        a2(c0714a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0714a c0714a, JSONObject jSONObject) {
        return b2(c0714a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0714a c0714a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0714a.aJz = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("monitor_info_list");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                a.b bVar = new a.b();
                bVar.parseJson(optJSONArray.optJSONObject(i4));
                c0714a.aJz.add(bVar);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0714a c0714a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "monitor_info_list", c0714a.aJz);
        return jSONObject;
    }
}
