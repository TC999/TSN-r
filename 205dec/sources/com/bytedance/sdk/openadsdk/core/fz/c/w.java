package com.bytedance.sdk.openadsdk.core.fz.c;

import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends xv<w> {
    @Override // com.bytedance.sdk.openadsdk.core.fz.c.xv, com.bytedance.sdk.openadsdk.core.fz.c.c
    public JSONObject c() {
        JSONObject c4 = super.c();
        try {
            c4.put("plugin_version", TTLiveCommerceHelper.getInstance().getLivePluginVersion());
        } catch (Exception unused) {
        }
        return c4;
    }
}
