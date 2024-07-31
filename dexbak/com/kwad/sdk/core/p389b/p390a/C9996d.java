package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9996d implements InterfaceC10273d<AdMatrixInfo.ActionBarInfoNew> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        m27090a(actionBarInfoNew, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        return m27089b(actionBarInfoNew, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27090a(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfoNew.maxTimeOut = jSONObject.optLong("maxTimeOut");
        actionBarInfoNew.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27089b(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = actionBarInfoNew.maxTimeOut;
        if (j != 0) {
            C11126t.putValue(jSONObject, "maxTimeOut", j);
        }
        int i = actionBarInfoNew.cardType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "cardType", i);
        }
        return jSONObject;
    }
}
