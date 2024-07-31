package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9053ae;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hr */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10122hr implements InterfaceC10273d<C9053ae.C9054a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9053ae.C9054a c9054a, JSONObject jSONObject) {
        m26844a(c9054a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9053ae.C9054a c9054a, JSONObject jSONObject) {
        return m26843b(c9054a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26844a(C9053ae.C9054a c9054a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9054a.playableExtraData = jSONObject.optString("playableExtraData");
        if (JSONObject.NULL.toString().equals(c9054a.playableExtraData)) {
            c9054a.playableExtraData = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26843b(C9053ae.C9054a c9054a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9054a.playableExtraData;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "playableExtraData", c9054a.playableExtraData);
        }
        return jSONObject;
    }
}
