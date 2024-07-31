package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.splashscreen.SplashPreloadManager;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hw */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10127hw implements InterfaceC10273d<SplashPreloadManager.PreLoadItem> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        m26834a(preLoadItem, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        return m26833b(preLoadItem, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26834a(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        preLoadItem.cacheTime = jSONObject.optLong("cacheTime");
        preLoadItem.expiredTime = jSONObject.optLong("expiredTime");
        preLoadItem.preloadId = jSONObject.optString("preloadId");
        if (JSONObject.NULL.toString().equals(preLoadItem.preloadId)) {
            preLoadItem.preloadId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26833b(SplashPreloadManager.PreLoadItem preLoadItem, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = preLoadItem.cacheTime;
        if (j != 0) {
            C11126t.putValue(jSONObject, "cacheTime", j);
        }
        long j2 = preLoadItem.expiredTime;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "expiredTime", j2);
        }
        String str = preLoadItem.preloadId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "preloadId", preLoadItem.preloadId);
        }
        return jSONObject;
    }
}
