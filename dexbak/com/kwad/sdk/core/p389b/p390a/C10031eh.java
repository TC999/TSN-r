package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9143d;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.eh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10031eh implements InterfaceC10273d<C9143d.C9144a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9143d.C9144a c9144a, JSONObject jSONObject) {
        m27026a(c9144a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9143d.C9144a c9144a, JSONObject jSONObject) {
        return m27025b(c9144a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27026a(C9143d.C9144a c9144a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9144a.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(c9144a.data)) {
            c9144a.data = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27025b(C9143d.C9144a c9144a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9144a.data;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "data", c9144a.data);
        }
        return jSONObject;
    }
}
