package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.reward.p258k.C7987n;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.gv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10099gv implements InterfaceC10273d<C7987n.C7988a> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C7987n.C7988a c7988a, JSONObject jSONObject) {
        m26890a(c7988a, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C7987n.C7988a c7988a, JSONObject jSONObject) {
        return m26889b(c7988a, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26890a(C7987n.C7988a c7988a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c7988a.status = jSONObject.optInt("status");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26889b(C7987n.C7988a c7988a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c7988a.status;
        if (i != 0) {
            C11126t.putValue(jSONObject, "status", i);
        }
        return jSONObject;
    }
}
