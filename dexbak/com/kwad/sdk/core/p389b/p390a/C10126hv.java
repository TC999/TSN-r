package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hv */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10126hv implements InterfaceC10273d<AdMatrixInfo.PreLandingPageTKInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo, JSONObject jSONObject) {
        m26836a(preLandingPageTKInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo, JSONObject jSONObject) {
        return m26835b(preLandingPageTKInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26836a(AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLandingPageTKInfo.preLandingPageShowType = jSONObject.optInt("preLandingPageShowType", new Integer("1").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26835b(AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "preLandingPageShowType", preLandingPageTKInfo.preLandingPageShowType);
        return jSONObject;
    }
}
