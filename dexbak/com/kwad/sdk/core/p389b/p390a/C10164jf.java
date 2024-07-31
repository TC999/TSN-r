package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jf */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10164jf implements InterfaceC10273d<AdMatrixInfo.SplashPlayCardTKInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        m26760a(splashPlayCardTKInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        return m26759b(splashPlayCardTKInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26760a(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashPlayCardTKInfo.tkTimeout = jSONObject.optInt("tkTimeout", new Integer(Constants.DEFAULT_UIN).intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26759b(AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "tkTimeout", splashPlayCardTKInfo.tkTimeout);
        return jSONObject;
    }
}
