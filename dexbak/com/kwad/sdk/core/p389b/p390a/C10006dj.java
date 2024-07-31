package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.dj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10006dj implements InterfaceC10273d<AdMatrixInfo.EndCardInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        m27070a(endCardInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        return m27069b(endCardInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27070a(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        endCardInfo.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
        endCardInfo.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27069b(AdMatrixInfo.EndCardInfo endCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = endCardInfo.cardShowPlayCount;
        if (i != 0) {
            C11126t.putValue(jSONObject, "cardShowPlayCount", i);
        }
        int i2 = endCardInfo.cardType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "cardType", i2);
        }
        return jSONObject;
    }
}
