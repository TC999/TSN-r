package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p333a.C9202h;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10121hq implements InterfaceC10273d<C9202h.C9204b> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9202h.C9204b c9204b, JSONObject jSONObject) {
        m26846a(c9204b, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9202h.C9204b c9204b, JSONObject jSONObject) {
        return m26845b(c9204b, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26846a(C9202h.C9204b c9204b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9204b.f29292ZI = jSONObject.optInt("playEndType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26845b(C9202h.C9204b c9204b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9204b.f29292ZI;
        if (i != 0) {
            C11126t.putValue(jSONObject, "playEndType", i);
        }
        return jSONObject;
    }
}
