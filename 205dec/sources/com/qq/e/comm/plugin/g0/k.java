package com.qq.e.comm.plugin.g0;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar, JSONObject jSONObject) {
        jVar.f43587a = jSONObject.optString(CampaignEx.JSON_KEY_CLICK_URL);
        jVar.f43588b = jSONObject.optString("invoke_url");
    }
}
