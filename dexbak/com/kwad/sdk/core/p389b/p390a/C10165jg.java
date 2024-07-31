package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9260u;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jg */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10165jg implements InterfaceC10273d<C9260u> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9260u c9260u, JSONObject jSONObject) {
        m26758a(c9260u, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9260u c9260u, JSONObject jSONObject) {
        return m26757b(c9260u, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26758a(C9260u c9260u, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9260u.f29319nE = jSONObject.optInt("currentTime");
        c9260u.aat = jSONObject.optBoolean("finished");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26757b(C9260u c9260u, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9260u.f29319nE;
        if (i != 0) {
            C11126t.putValue(jSONObject, "currentTime", i);
        }
        boolean z = c9260u.aat;
        if (z) {
            C11126t.putValue(jSONObject, "finished", z);
        }
        return jSONObject;
    }
}
