package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9256q;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.iq */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10148iq implements InterfaceC10273d<C9256q> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9256q c9256q, JSONObject jSONObject) {
        m26792a(c9256q, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9256q c9256q, JSONObject jSONObject) {
        return m26791b(c9256q, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26792a(C9256q c9256q, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9256q.aar = jSONObject.optBoolean("userForce");
        c9256q.type = jSONObject.optInt("type");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26791b(C9256q c9256q, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = c9256q.aar;
        if (z) {
            C11126t.putValue(jSONObject, "userForce", z);
        }
        int i = c9256q.type;
        if (i != 0) {
            C11126t.putValue(jSONObject, "type", i);
        }
        return jSONObject;
    }
}
