package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9155j;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.en */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10037en implements InterfaceC10273d<C9155j.C9156a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9155j.C9156a c9156a, JSONObject jSONObject) {
        m27014a(c9156a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9155j.C9156a c9156a, JSONObject jSONObject) {
        return m27013b(c9156a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27014a(C9155j.C9156a c9156a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9156a.data = jSONObject.optString("data");
        if (JSONObject.NULL.toString().equals(c9156a.data)) {
            c9156a.data = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27013b(C9155j.C9156a c9156a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9156a.data;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "data", c9156a.data);
        }
        return jSONObject;
    }
}
