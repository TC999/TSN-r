package com.bytedance.sdk.openadsdk.core.live.sr;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static int c(Map<String, Object> map) {
        try {
            return ((Integer) map.get("live_saas_param_interaction_type")).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean w(String str) {
        JSONObject optJSONObject;
        if (TextUtils.isEmpty(str) || (optJSONObject = new JSONObject(str).optJSONObject("enter_request")) == null) {
            return false;
        }
        int optInt = optJSONObject.optInt("activity_type");
        JSONArray optJSONArray = optJSONObject.optJSONArray("incr_coupon");
        if (optInt == 1 && optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                if (optJSONObject2.optInt("interaction_type") == 1 && optJSONObject2.optInt("task_time") > 0 && optJSONObject2.optLong("value") > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(String str) {
        try {
            if (TextUtils.isEmpty(str) || new JSONObject(str).optJSONObject("enter_request") == null) {
                return false;
            }
            return !w(str);
        } catch (Exception unused) {
            return false;
        }
    }
}
