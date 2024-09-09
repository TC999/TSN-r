package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.j.a;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class kf implements com.kwad.sdk.core.d<a.C0686a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0686a c0686a, JSONObject jSONObject) {
        a2(c0686a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0686a c0686a, JSONObject jSONObject) {
        return b2(c0686a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(a.C0686a c0686a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0686a.aoL = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                c0686a.aoL.add((String) optJSONArray.opt(i4));
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(a.C0686a c0686a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "blackList", c0686a.aoL);
        return jSONObject;
    }
}
