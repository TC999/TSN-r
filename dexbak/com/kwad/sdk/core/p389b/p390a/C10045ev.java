package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.jshandler.C9063ai;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ev */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10045ev implements InterfaceC10273d<C9063ai.C9065a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9063ai.C9065a c9065a, JSONObject jSONObject) {
        m26998a(c9065a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9063ai.C9065a c9065a, JSONObject jSONObject) {
        return m26997b(c9065a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26998a(C9063ai.C9065a c9065a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9065a.type = jSONObject.optInt("type");
        c9065a.f29144Xn = jSONObject.optInt("playDuration");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26997b(C9063ai.C9065a c9065a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9065a.type;
        if (i != 0) {
            C11126t.putValue(jSONObject, "type", i);
        }
        int i2 = c9065a.f29144Xn;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "playDuration", i2);
        }
        return jSONObject;
    }
}
