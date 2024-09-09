package com.qq.e.comm.plugin.g0;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
final class r {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(q qVar, JSONObject jSONObject) {
        qVar.f43732j1 = jSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
        qVar.f43733k1 = a0.b(jSONObject.optJSONArray("img_list"));
        qVar.f43734l1 = jSONObject.optInt("pattern_type");
    }
}
