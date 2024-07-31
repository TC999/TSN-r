package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p381j.C9844a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10191kf implements InterfaceC10273d<C9844a.C9846a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9844a.C9846a c9846a, JSONObject jSONObject) {
        m26706a(c9846a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9844a.C9846a c9846a, JSONObject jSONObject) {
        return m26705b(c9846a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26706a(C9844a.C9846a c9846a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9846a.aoL = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                c9846a.aoL.add((String) optJSONArray.opt(i));
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26705b(C9844a.C9846a c9846a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "blackList", c9846a.aoL);
        return jSONObject;
    }
}
