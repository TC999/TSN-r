package com.kwad.sdk.core.webview.request;

import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.AbstractC10418d;
import com.kwad.sdk.core.network.C10440p;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.request.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10645a extends AbstractC10418d {
    private String aER;
    private String mUrl;

    public C10645a(String str, String str2, String str3) {
        JSONObject jSONObject;
        this.mUrl = str;
        this.aER = str2;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
            jSONObject = null;
        }
        C10331c.m26254d("WebCardGetDataRequest", "mBodyParams1 size=" + this.mBodyParams.length());
        if (jSONObject != null) {
            C10331c.m26254d("WebCardGetDataRequest", "paramsJsonObj=" + jSONObject.toString());
        }
        C11126t.merge(this.mBodyParams, jSONObject);
        C10331c.m26254d("WebCardGetDataRequest", "mBodyParams2 size=" + this.mBodyParams.length());
        addHeader("user-agent", C10440p.getUserAgent());
        C10331c.m26254d("WebCardGetDataRequest", "user-agent" + C10440p.getUserAgent());
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public String getUrl() {
        return C10760g.m24895xV() + this.mUrl;
    }
}
