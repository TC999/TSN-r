package com.kwad.sdk.core.report;

import android.text.TextUtils;
import com.kwad.sdk.C10760g;
import com.kwad.sdk.core.network.AbstractC10418d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11126t;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.report.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10454f extends AbstractC10418d {
    protected String axz;

    public C10454f(List<C10464n> list) {
        this.axz = "";
        if (list == null || list.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (C10464n c10464n : list) {
            C11126t.m23679a(jSONArray, c10464n.buildReportData());
        }
        putBody("actionList", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final JSONObject getBody() {
        if (encryptDisable() && !TextUtils.isEmpty(this.axz)) {
            putBody("actionListString", this.axz);
        }
        return super.getBody();
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b
    public final String getBodyParamsString() {
        String bodyParamsString = super.getBodyParamsString();
        try {
            if (TextUtils.isEmpty(this.axz)) {
                return bodyParamsString;
            }
            StringBuilder sb = new StringBuilder(bodyParamsString);
            sb.insert(sb.length() - 1, this.axz);
            return sb.toString();
        } catch (Exception e) {
            C10331c.printStackTrace(e);
            return bodyParamsString;
        }
    }

    @Override // com.kwad.sdk.core.network.AbstractC10410b, com.kwad.sdk.core.network.InterfaceC10420f
    public final String getUrl() {
        return C10760g.m24890ya();
    }

    public C10454f(String str) {
        this.axz = str;
    }
}
