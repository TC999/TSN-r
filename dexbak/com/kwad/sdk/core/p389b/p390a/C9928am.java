package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.am */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9928am implements InterfaceC10273d<AdInfo.AdShowVideoH5Info> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        m27218a(adShowVideoH5Info, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        return m27217b(adShowVideoH5Info, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27218a(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adShowVideoH5Info.showPageType = jSONObject.optInt("showPageType");
        adShowVideoH5Info.videoAutoLoopAtH5 = jSONObject.optBoolean("videoAutoLoopAtH5");
        adShowVideoH5Info.videoMutedAtH5 = jSONObject.optBoolean("videoMutedAtH5");
        adShowVideoH5Info.videoClickAtH5 = jSONObject.optBoolean("videoClickAtH5");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27217b(AdInfo.AdShowVideoH5Info adShowVideoH5Info, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adShowVideoH5Info.showPageType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "showPageType", i);
        }
        boolean z = adShowVideoH5Info.videoAutoLoopAtH5;
        if (z) {
            C11126t.putValue(jSONObject, "videoAutoLoopAtH5", z);
        }
        boolean z2 = adShowVideoH5Info.videoMutedAtH5;
        if (z2) {
            C11126t.putValue(jSONObject, "videoMutedAtH5", z2);
        }
        boolean z3 = adShowVideoH5Info.videoClickAtH5;
        if (z3) {
            C11126t.putValue(jSONObject, "videoClickAtH5", z3);
        }
        return jSONObject;
    }
}
