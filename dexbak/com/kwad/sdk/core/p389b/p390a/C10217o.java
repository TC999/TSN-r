package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.commercial.p376e.C9831b;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10217o implements InterfaceC10273d<C9831b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9831b c9831b, JSONObject jSONObject) {
        m26654a(c9831b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9831b c9831b, JSONObject jSONObject) {
        return m26653b(c9831b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26654a(C9831b c9831b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9831b.aoA = jSONObject.optString("error_name");
        if (JSONObject.NULL.toString().equals(c9831b.aoA)) {
            c9831b.aoA = "";
        }
        c9831b.aoB = jSONObject.optString("error_data");
        if (JSONObject.NULL.toString().equals(c9831b.aoB)) {
            c9831b.aoB = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26653b(C9831b c9831b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9831b.aoA;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "error_name", c9831b.aoA);
        }
        String str2 = c9831b.aoB;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "error_data", c9831b.aoB);
        }
        return jSONObject;
    }
}
