package com.kwad.components.core.request;

import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.AbstractC10418d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.utils.C11137y;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.request.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8917f extends AbstractC10418d {
    public C8917f() {
        try {
            JSONArray jSONArray = new JSONArray();
            C11126t.m23679a(jSONArray, new JSONObject());
            putBody("impInfo", jSONArray);
            putBody("appTag", C11137y.m23634LK());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return C10760g.m24889yb();
    }
}
