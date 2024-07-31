package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9258s;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.it */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10151it implements InterfaceC10273d<C9258s> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9258s c9258s, JSONObject jSONObject) {
        m26786a(c9258s, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9258s c9258s, JSONObject jSONObject) {
        return m26785b(c9258s, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26786a(C9258s c9258s, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9258s.message = jSONObject.optString("message");
        if (JSONObject.NULL.toString().equals(c9258s.message)) {
            c9258s.message = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26785b(C9258s c9258s, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9258s.message;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "message", c9258s.message);
        }
        return jSONObject;
    }
}
