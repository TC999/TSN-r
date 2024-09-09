package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.l;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    @NonNull
    public static a bD(@NonNull AdTemplate adTemplate) {
        return new a(adTemplate, l.em(adTemplate));
    }

    public final String Ba() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e4) {
            c.printStackTrace(e4);
        }
        return jSONObject.toString();
    }

    public a(@NonNull AdTemplate adTemplate, long j4) {
        this.clickTime = -1L;
        this.photoId = e.dW(adTemplate);
        this.clickTime = j4;
        this.adStyle = e.dL(adTemplate);
        this.contentType = e.dM(adTemplate);
    }
}
