package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class hv implements com.kwad.sdk.core.d<AdMatrixInfo.PreLandingPageTKInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo, JSONObject jSONObject) {
        a2(preLandingPageTKInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo, JSONObject jSONObject) {
        return b2(preLandingPageTKInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLandingPageTKInfo.preLandingPageShowType = jSONObject.optInt("preLandingPageShowType", new Integer("1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "preLandingPageShowType", preLandingPageTKInfo.preLandingPageShowType);
        return jSONObject;
    }
}
