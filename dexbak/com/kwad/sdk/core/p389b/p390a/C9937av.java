package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.av */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9937av implements InterfaceC10273d<AdVideoPreCacheConfig> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        m27200a(adVideoPreCacheConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        return m27199b(adVideoPreCacheConfig, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27200a(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adVideoPreCacheConfig.adVideoPreCacheSize = jSONObject.optInt("adVideoPreCacheSize", new Integer("800").intValue());
        adVideoPreCacheConfig.continueLoadingAll = jSONObject.optBoolean("continueLoadingAll");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27199b(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "adVideoPreCacheSize", adVideoPreCacheConfig.adVideoPreCacheSize);
        boolean z = adVideoPreCacheConfig.continueLoadingAll;
        if (z) {
            C11126t.putValue(jSONObject, "continueLoadingAll", z);
        }
        return jSONObject;
    }
}
