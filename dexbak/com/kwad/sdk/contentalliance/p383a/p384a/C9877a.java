package com.kwad.sdk.contentalliance.p383a.p384a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11103l;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.contentalliance.a.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9877a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public C9877a() {
        this.clickTime = -1L;
    }

    @NonNull
    /* renamed from: bD */
    public static C9877a m27478bD(@NonNull AdTemplate adTemplate) {
        return new C9877a(adTemplate, C11103l.m23772em(adTemplate));
    }

    /* renamed from: Ba */
    public final String m27479Ba() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
        }
        return jSONObject.toString();
    }

    public C9877a(@NonNull AdTemplate adTemplate, long j) {
        this.clickTime = -1L;
        this.photoId = C10487e.m25635dW(adTemplate);
        this.clickTime = j;
        this.adStyle = C10487e.m25646dL(adTemplate);
        this.contentType = C10487e.m25645dM(adTemplate);
    }
}
