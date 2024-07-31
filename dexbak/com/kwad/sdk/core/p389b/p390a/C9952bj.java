package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9242c;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9952bj implements InterfaceC10273d<C9242c> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9242c c9242c, JSONObject jSONObject) {
        m27170a(c9242c, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9242c c9242c, JSONObject jSONObject) {
        return m27169b(c9242c, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27170a(C9242c c9242c, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9242c.aag = jSONObject.optInt("showCount", new Integer("0").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27169b(C9242c c9242c, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "showCount", c9242c.aag);
        return jSONObject;
    }
}
