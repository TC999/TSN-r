package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.aj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9925aj implements InterfaceC10273d<AdInfo.AdPreloadInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        m27224a(adPreloadInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        return m27223b(adPreloadInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27224a(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adPreloadInfo.preloadId = jSONObject.optString("preloadId");
        if (JSONObject.NULL.toString().equals(adPreloadInfo.preloadId)) {
            adPreloadInfo.preloadId = "";
        }
        adPreloadInfo.preloadType = jSONObject.optInt("preloadType");
        adPreloadInfo.preloadTips = jSONObject.optString("preloadTips", new String("已提前加载"));
        adPreloadInfo.validityPeriod = jSONObject.optInt("validityPeriod", new Integer("604800").intValue());
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27223b(AdInfo.AdPreloadInfo adPreloadInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adPreloadInfo.preloadId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "preloadId", adPreloadInfo.preloadId);
        }
        int i = adPreloadInfo.preloadType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "preloadType", i);
        }
        C11126t.putValue(jSONObject, "preloadTips", adPreloadInfo.preloadTips);
        C11126t.putValue(jSONObject, "validityPeriod", adPreloadInfo.validityPeriod);
        return jSONObject;
    }
}
