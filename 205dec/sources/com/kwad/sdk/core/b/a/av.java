package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class av implements com.kwad.sdk.core.d<AdVideoPreCacheConfig> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        a2(adVideoPreCacheConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        return b2(adVideoPreCacheConfig, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adVideoPreCacheConfig.adVideoPreCacheSize = jSONObject.optInt("adVideoPreCacheSize", new Integer("800").intValue());
        adVideoPreCacheConfig.continueLoadingAll = jSONObject.optBoolean("continueLoadingAll");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdVideoPreCacheConfig adVideoPreCacheConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "adVideoPreCacheSize", adVideoPreCacheConfig.adVideoPreCacheSize);
        boolean z3 = adVideoPreCacheConfig.continueLoadingAll;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "continueLoadingAll", z3);
        }
        return jSONObject;
    }
}
