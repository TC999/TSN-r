package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9096ar;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ba */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9943ba implements InterfaceC10273d<C9096ar.C9097a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9096ar.C9097a c9097a, JSONObject jSONObject) {
        m27188a(c9097a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9096ar.C9097a c9097a, JSONObject jSONObject) {
        return m27187b(c9097a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27188a(C9096ar.C9097a c9097a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9097a.f29189id = jSONObject.optInt("id");
        c9097a.status = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27187b(C9096ar.C9097a c9097a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9097a.f29189id;
        if (i != 0) {
            C11126t.putValue(jSONObject, "id", i);
        }
        int i2 = c9097a.status;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "status", i2);
        }
        return jSONObject;
    }
}
