package com.bytedance.msdk.ux.xv;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f28464c;

    private w() {
    }

    public static w c() {
        if (f28464c == null) {
            synchronized (w.class) {
                if (f28464c == null) {
                    f28464c = new w();
                }
            }
        }
        return f28464c;
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        Context context = com.bytedance.msdk.core.c.getContext();
        com.bytedance.sdk.openadsdk.api.plugin.w.w(context, "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.w.k().a(), 0).edit().putString("rit_conf", jSONArray.toString()).apply();
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Context context = com.bytedance.msdk.core.c.getContext();
        com.bytedance.sdk.openadsdk.api.plugin.w.w(context, "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.w.k().a(), 0).edit().putString("adn_init_conf", jSONObject.toString()).apply();
    }
}
