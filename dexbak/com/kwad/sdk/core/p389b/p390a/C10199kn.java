package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9262w;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kn */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10199kn implements InterfaceC10273d<C9262w> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9262w c9262w, JSONObject jSONObject) {
        m26690a(c9262w, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9262w c9262w, JSONObject jSONObject) {
        return m26689b(c9262w, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26690a(C9262w c9262w, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9262w.aav = jSONObject.optInt("videoCloseTime", new Integer("0").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26689b(C9262w c9262w, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "videoCloseTime", c9262w.aav);
        return jSONObject;
    }
}
