package com.kwad.sdk.core.report;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f extends com.kwad.sdk.core.network.d {
    protected String axz;

    public f(List<n> list) {
        this.axz = "";
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (n nVar : list) {
            com.kwad.sdk.utils.t.a(jSONArray, nVar.buildReportData());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        if (encryptDisable() && !TextUtils.isEmpty(this.axz)) {
            putBody("actionListString", this.axz);
        }
        return super.getBody();
    }

    @Override // com.kwad.sdk.core.network.b
    public final String getBodyParamsString() {
        String bodyParamsString = super.getBodyParamsString();
        try {
            if (TextUtils.isEmpty(this.axz)) {
                return bodyParamsString;
            }
            StringBuilder sb = new StringBuilder(bodyParamsString);
            sb.insert(sb.length() - 1, this.axz);
            return sb.toString();
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
            return bodyParamsString;
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.g.ya();
    }

    public f(String str) {
        this.axz = str;
    }
}
