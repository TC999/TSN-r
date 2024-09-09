package com.bytedance.sdk.openadsdk.core.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.CodeGroupRitObject;
import com.bytedance.sdk.openadsdk.TTCodeGroupRit;
import com.bytedance.sdk.openadsdk.core.ck;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.xv;
import com.bytedance.sdk.openadsdk.core.xv.ux;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static TTCodeGroupRit w(JSONObject jSONObject) {
        final int optInt;
        final String optString = jSONObject.optString("rit");
        if (!TextUtils.isEmpty(optString) && (optInt = jSONObject.optInt("ad_slot_type")) >= 1 && optInt <= 9) {
            return new TTCodeGroupRit() { // from class: com.bytedance.sdk.openadsdk.core.f.c.2
                @Override // com.bytedance.sdk.openadsdk.TTCodeGroupRit
                public String getRit() {
                    return optString;
                }

                @Override // com.bytedance.sdk.openadsdk.TTCodeGroupRit
                public int getSlotType() {
                    return optInt;
                }
            };
        }
        return null;
    }

    public static void c(CodeGroupRitObject codeGroupRitObject) {
        TTCodeGroupRit.TTCodeGroupRitListener listener;
        TTCodeGroupRit w3;
        if (codeGroupRitObject == null || (listener = codeGroupRitObject.getListener()) == null) {
            return;
        }
        long codeGroupId = codeGroupRitObject.getCodeGroupId();
        if (ls.w().nd()) {
            long db = ls.w().db();
            String w4 = xv.c().w("code_group_" + codeGroupId, (String) null);
            if (!TextUtils.isEmpty(w4)) {
                try {
                    JSONObject jSONObject = new JSONObject(w4);
                    if (System.currentTimeMillis() - jSONObject.optLong(CampaignEx.JSON_KEY_TIMESTAMP) < db * 1000 && (w3 = w(jSONObject)) != null) {
                        listener.onSuccess(w3);
                        return;
                    }
                } catch (Exception unused) {
                }
            }
            c(codeGroupId, listener);
            return;
        }
        listener.onFail(491, "slot ab, feature is disabled");
    }

    private static void c(final long j4, final TTCodeGroupRit.TTCodeGroupRitListener tTCodeGroupRitListener) {
        ls.c().c(j4, new ck.xv<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.f.c.1
            @Override // com.bytedance.sdk.openadsdk.core.ck.xv
            public void c(int i4, String str) {
                TTCodeGroupRit.TTCodeGroupRitListener.this.onFail(i4, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ck.xv
            public void c(JSONObject jSONObject) {
                TTCodeGroupRit w3 = c.w(jSONObject);
                if (w3 == null) {
                    TTCodeGroupRit.TTCodeGroupRitListener.this.onFail(492, "slot ab, slot result is empty");
                    return;
                }
                TTCodeGroupRit.TTCodeGroupRitListener.this.onSuccess(w3);
                try {
                    jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
                } catch (Exception unused) {
                }
                com.bytedance.sdk.component.f.c c4 = xv.c();
                c4.c("code_group_" + j4, jSONObject.toString());
                String optString = jSONObject.optString("dynamic_slot_ab_extra");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                ux.c().c(w3.getRit(), optString);
            }
        });
    }
}
