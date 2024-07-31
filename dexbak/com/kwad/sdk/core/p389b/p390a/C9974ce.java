package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9246g;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ce */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9974ce implements InterfaceC10273d<C9246g> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9246g c9246g, JSONObject jSONObject) {
        m27126a(c9246g, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9246g c9246g, JSONObject jSONObject) {
        return m27125b(c9246g, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27126a(C9246g c9246g, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9246g.f29315KG = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(c9246g.f29315KG)) {
            c9246g.f29315KG = "";
        }
        c9246g.actionType = jSONObject.optInt("actionType");
        c9246g.f29316VN = jSONObject.optInt("adCacheId");
        c9246g.f29314Jj = jSONObject.optString("creativeId");
        if (JSONObject.NULL.toString().equals(c9246g.f29314Jj)) {
            c9246g.f29314Jj = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27125b(C9246g c9246g, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c9246g.f29315KG;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "payload", c9246g.f29315KG);
        }
        int i = c9246g.actionType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "actionType", i);
        }
        int i2 = c9246g.f29316VN;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "adCacheId", i2);
        }
        String str2 = c9246g.f29314Jj;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "creativeId", c9246g.f29314Jj);
        }
        return jSONObject;
    }
}
