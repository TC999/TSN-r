package com.bytedance.sdk.openadsdk.core.nativeexpress.onepointfive;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.eq;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {
    public static int c(com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        try {
            if (!c() || TextUtils.isEmpty(wVar.ys())) {
                return 0;
            }
            JSONObject jSONObject = new JSONObject(wVar.ys());
            if (jSONObject.has("_tt_group_load_more")) {
                return jSONObject.optInt("_tt_group_load_more");
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    public static boolean c() {
        return eq.f33190w >= 4700;
    }
}
