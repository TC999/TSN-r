package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10004dh implements InterfaceC10273d<C10819a.C10821a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10819a.C10821a c10821a, JSONObject jSONObject) {
        m27074a(c10821a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10819a.C10821a c10821a, JSONObject jSONObject) {
        return m27073b(c10821a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27074a(C10819a.C10821a c10821a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10821a.aJz = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("monitor_info_list");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                C10819a.C10822b c10822b = new C10819a.C10822b();
                c10822b.parseJson(optJSONArray.optJSONObject(i));
                c10821a.aJz.add(c10822b);
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27073b(C10819a.C10821a c10821a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "monitor_info_list", c10821a.aJz);
        return jSONObject;
    }
}
