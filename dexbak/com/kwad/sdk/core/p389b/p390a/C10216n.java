package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9240a;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10216n implements InterfaceC10273d<C9240a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9240a c9240a, JSONObject jSONObject) {
        m26656a(c9240a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9240a c9240a, JSONObject jSONObject) {
        return m26655b(c9240a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26656a(C9240a c9240a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9240a.aae = jSONObject.optInt("hasConverted");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26655b(C9240a c9240a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9240a.aae;
        if (i != 0) {
            C11126t.putValue(jSONObject, "hasConverted", i);
        }
        return jSONObject;
    }
}
