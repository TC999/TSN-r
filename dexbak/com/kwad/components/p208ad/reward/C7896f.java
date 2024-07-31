package com.kwad.components.p208ad.reward;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.AbstractC10418d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7896f extends AbstractC10418d {
    public C7896f(AdTemplate adTemplate) {
        putBody("callbackUrlInfo", C10483a.m25892bP(C10487e.m25641dQ(adTemplate)));
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        C11126t.m23679a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        try {
            String m25891bQ = C10483a.m25891bQ(C10487e.m25641dQ(adTemplate));
            if (TextUtils.isEmpty(m25891bQ)) {
                return;
            }
            putBody("serverExt", new JSONObject(m25891bQ));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return C10760g.m24888yc();
    }
}
