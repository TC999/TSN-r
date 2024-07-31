package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.report.C10458h;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.open.SocialConstants;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ca */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9970ca implements InterfaceC10273d<C10458h> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(C10458h c10458h, JSONObject jSONObject) {
        m27134a(c10458h, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(C10458h c10458h, JSONObject jSONObject) {
        return m27133b(c10458h, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27134a(C10458h c10458h, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10458h.llsid = jSONObject.optLong("llsid");
        c10458h.creativeId = jSONObject.optLong(CampaignEx.JSON_KEY_CREATIVE_ID);
        c10458h.score = jSONObject.optInt("score");
        c10458h.axF = jSONObject.optInt("is_bidding");
        c10458h.source = jSONObject.optString(SocialConstants.PARAM_SOURCE);
        if (JSONObject.NULL.toString().equals(c10458h.source)) {
            c10458h.source = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27133b(C10458h c10458h, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = c10458h.llsid;
        if (j != 0) {
            C11126t.putValue(jSONObject, "llsid", j);
        }
        long j2 = c10458h.creativeId;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_CREATIVE_ID, j2);
        }
        int i = c10458h.score;
        if (i != 0) {
            C11126t.putValue(jSONObject, "score", i);
        }
        int i2 = c10458h.axF;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "is_bidding", i2);
        }
        String str = c10458h.source;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, SocialConstants.PARAM_SOURCE, c10458h.source);
        }
        return jSONObject;
    }
}
