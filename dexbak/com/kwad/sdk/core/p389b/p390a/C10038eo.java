package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.core.webview.tachikoma.p334b.C9248i;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.eo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10038eo implements InterfaceC10273d<C9248i> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C9248i c9248i, JSONObject jSONObject) {
        m27012a(c9248i, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C9248i c9248i, JSONObject jSONObject) {
        return m27011b(c9248i, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27012a(C9248i c9248i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c9248i.rewardTime = jSONObject.optInt("rewardTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27011b(C9248i c9248i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c9248i.rewardTime;
        if (i != 0) {
            C11126t.putValue(jSONObject, "rewardTime", i);
        }
        return jSONObject;
    }
}
