package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d implements com.kwad.sdk.core.d<AdMatrixInfo.ActionBarInfoNew> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        a2(actionBarInfoNew, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        return b2(actionBarInfoNew, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        actionBarInfoNew.maxTimeOut = jSONObject.optLong("maxTimeOut");
        actionBarInfoNew.cardType = jSONObject.optInt("cardType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.ActionBarInfoNew actionBarInfoNew, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = actionBarInfoNew.maxTimeOut;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "maxTimeOut", j4);
        }
        int i4 = actionBarInfoNew.cardType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardType", i4);
        }
        return jSONObject;
    }
}
