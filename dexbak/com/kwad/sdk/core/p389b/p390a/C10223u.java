package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9182w;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.u */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10223u implements InterfaceC10273d<C9182w.C9183a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9182w.C9183a c9183a, JSONObject jSONObject) {
        m26642a(c9183a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9182w.C9183a c9183a, JSONObject jSONObject) {
        return m26641b(c9183a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26642a(C9182w.C9183a c9183a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9183a.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        c9183a.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26641b(C9182w.C9183a c9183a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "creativeId", c9183a.creativeId);
        C11126t.putValue(jSONObject, "adStyle", c9183a.adStyle);
        return jSONObject;
    }
}
