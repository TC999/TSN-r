package com.qq.e.comm.plugin.nativeadunified;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.qq.e.comm.plugin.g0.a0;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
final class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, JSONObject jSONObject) {
        gVar.f44924g1 = jSONObject.optInt("pattern_type");
        gVar.f44925h1 = a0.b(jSONObject.optJSONArray("img_list"));
        gVar.f44926i1 = jSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
    }
}
