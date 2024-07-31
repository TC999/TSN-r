package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10091gn implements InterfaceC10273d<C9252m> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9252m c9252m, JSONObject jSONObject) {
        m26906a(c9252m, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9252m c9252m, JSONObject jSONObject) {
        return m26905b(c9252m, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26906a(C9252m c9252m, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9252m.aao = jSONObject.optBoolean("muted");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26905b(C9252m c9252m, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c9252m.aao;
        if (z) {
            C11126t.putValue(jSONObject, "muted", z);
        }
        return jSONObject;
    }
}
