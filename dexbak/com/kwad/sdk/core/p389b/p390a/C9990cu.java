package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9247h;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.cu */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9990cu implements InterfaceC10273d<C9247h> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9247h c9247h, JSONObject jSONObject) {
        m27102a(c9247h, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9247h c9247h, JSONObject jSONObject) {
        return m27101b(c9247h, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27102a(C9247h c9247h, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9247h.aaj = jSONObject.optInt("hasDeepReward");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27101b(C9247h c9247h, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9247h.aaj;
        if (i != 0) {
            C11126t.putValue(jSONObject, "hasDeepReward", i);
        }
        return jSONObject;
    }
}
