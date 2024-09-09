package com.qq.e.comm.plugin.g0;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
final class g0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(f0 f0Var, JSONObject jSONObject) {
        f0Var.f43566g1 = jSONObject.optString(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
        f0Var.f43567h1 = jSONObject.optString("landing_page");
        f0Var.f43569j1 = jSONObject.optString("reward_txt");
    }
}
