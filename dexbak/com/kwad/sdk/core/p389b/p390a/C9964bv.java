package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9244e;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.bv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9964bv implements InterfaceC10273d<C9244e> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9244e c9244e, JSONObject jSONObject) {
        m27146a(c9244e, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9244e c9244e, JSONObject jSONObject) {
        return m27145b(c9244e, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27146a(C9244e c9244e, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9244e.height = jSONObject.optInt("height");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27145b(C9244e c9244e, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9244e.height;
        if (i != 0) {
            C11126t.putValue(jSONObject, "height", i);
        }
        return jSONObject;
    }
}
