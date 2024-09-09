package com.bytedance.sdk.openadsdk.core.eq;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t {
    public static boolean c() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject wo = com.bytedance.sdk.openadsdk.core.ls.w().wo();
        if (wo == null) {
            com.bytedance.sdk.component.utils.a.w("tp_dr", "not dylite false");
            return false;
        }
        long optLong = wo.optLong(CampaignEx.JSON_NATIVE_VIDEO_START, 1707480000000L);
        long optLong2 = wo.optLong("end", 1707498000000L);
        com.bytedance.sdk.component.utils.a.w("tp_dr", "cur:" + currentTimeMillis + " s:" + optLong + " e:" + optLong2);
        return currentTimeMillis >= optLong && currentTimeMillis <= optLong2;
    }

    public static boolean w() {
        JSONObject wo = com.bytedance.sdk.openadsdk.core.ls.w().wo();
        return wo != null && c() && wo.optInt("force_drop", 0) == 1;
    }
}
