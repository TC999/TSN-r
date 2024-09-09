package com.kwad.sdk.collector.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.g;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends d {
    public b(Collection<e> collection) {
        putBody("collectData", a(collection));
        putBody("collectType", 1);
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    private static JSONArray a(Collection<e> collection) {
        JSONArray jSONArray = new JSONArray();
        for (e eVar : collection) {
            JSONObject AC = eVar.AC();
            if (AC != null) {
                jSONArray.put(AC);
            }
        }
        return jSONArray;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return g.yf();
    }
}
