package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.report.C10460j;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10008dl implements InterfaceC10273d<C10460j> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10460j c10460j, JSONObject jSONObject) {
        m27066a(c10460j, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10460j c10460j, JSONObject jSONObject) {
        return m27065b(c10460j, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27066a(C10460j c10460j, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10460j.axG = jSONObject.optString("log");
        if (JSONObject.NULL.toString().equals(c10460j.axG)) {
            c10460j.axG = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27065b(C10460j c10460j, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c10460j.axG;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "log", c10460j.axG);
        }
        return jSONObject;
    }
}
