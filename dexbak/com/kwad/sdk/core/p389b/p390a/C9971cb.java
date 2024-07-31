package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9245f;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9971cb implements InterfaceC10273d<C9245f> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9245f c9245f, JSONObject jSONObject) {
        m27132a(c9245f, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9245f c9245f, JSONObject jSONObject) {
        return m27131b(c9245f, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27132a(C9245f c9245f, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9245f.aai = jSONObject.optInt("closeDelaySeconds");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27131b(C9245f c9245f, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9245f.aai;
        if (i != 0) {
            C11126t.putValue(jSONObject, "closeDelaySeconds", i);
        }
        return jSONObject;
    }
}
