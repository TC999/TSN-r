package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9251l;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fz */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10076fz implements InterfaceC10273d<C9251l> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9251l c9251l, JSONObject jSONObject) {
        m26936a(c9251l, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9251l c9251l, JSONObject jSONObject) {
        return m26935b(c9251l, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26936a(C9251l c9251l, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9251l.aan = jSONObject.optString("landingPageUrl");
        if (JSONObject.NULL.toString().equals(c9251l.aan)) {
            c9251l.aan = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26935b(C9251l c9251l, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9251l.aan;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "landingPageUrl", c9251l.aan);
        }
        return jSONObject;
    }
}
