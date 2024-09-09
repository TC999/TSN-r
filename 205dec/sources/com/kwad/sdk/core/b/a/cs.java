package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class cs implements com.kwad.sdk.core.d<AdInfo.CutRuleInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        a2(cutRuleInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        return b2(cutRuleInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cutRuleInfo.picHeight = jSONObject.optInt("picHeight");
        cutRuleInfo.viewTopMargin = jSONObject.optInt("viewTopMargin");
        cutRuleInfo.safeAreaHeight = jSONObject.optInt("safeAreaHeight");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdInfo.CutRuleInfo cutRuleInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = cutRuleInfo.picHeight;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "picHeight", i4);
        }
        int i5 = cutRuleInfo.viewTopMargin;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "viewTopMargin", i5);
        }
        int i6 = cutRuleInfo.safeAreaHeight;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "safeAreaHeight", i6);
        }
        return jSONObject;
    }
}
