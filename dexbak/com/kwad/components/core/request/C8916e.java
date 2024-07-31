package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.AbstractC10418d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.request.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8916e extends AbstractC10418d {

    /* renamed from: Rr */
    public long f28800Rr;

    public C8916e(int i, AdTemplate adTemplate) {
        String m25892bP = C10483a.m25892bP(C10487e.m25641dQ(adTemplate));
        try {
            String m25891bQ = C10483a.m25891bQ(C10487e.m25641dQ(adTemplate));
            try {
                if (!TextUtils.isEmpty(m25891bQ)) {
                    putBody("serverExt", new JSONObject(m25891bQ));
                }
            } catch (JSONException e) {
                C10331c.printStackTrace(e);
            }
            if (!TextUtils.isEmpty(m25892bP) && m25892bP != null) {
                JSONObject jSONObject = new JSONObject(m25892bP);
                C11126t.putValue(jSONObject, "checkType", i);
                putBody("callbackUrlInfo", jSONObject.toString());
            }
        } catch (Exception e2) {
            C10331c.printStackTrace(e2);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        C11126t.m23679a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return C10760g.m24884yg();
    }
}
