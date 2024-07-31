package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9147f;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ej */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10033ej implements InterfaceC10273d<C9147f.C9148a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9147f.C9148a c9148a, JSONObject jSONObject) {
        m27022a(c9148a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9147f.C9148a c9148a, JSONObject jSONObject) {
        return m27021b(c9148a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27022a(C9147f.C9148a c9148a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9148a.loadType = jSONObject.optInt("loadType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27021b(C9147f.C9148a c9148a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9148a.loadType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "loadType", i);
        }
        return jSONObject;
    }
}
