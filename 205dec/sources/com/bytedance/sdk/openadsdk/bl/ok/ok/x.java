package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTWidgetManager;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class x extends TTWidgetManager {
    private final Bridge ok;

    public x(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTWidgetManager
    public boolean updateWidgetWithType(int i4, JSONObject jSONObject) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(2);
        c4.f(0, i4);
        c4.h(1, jSONObject);
        return ((Boolean) this.ok.call(264001, c4.a(), Boolean.TYPE)).booleanValue();
    }
}
