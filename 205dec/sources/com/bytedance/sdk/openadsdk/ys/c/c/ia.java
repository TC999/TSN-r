package com.bytedance.sdk.openadsdk.ys.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTWidgetManager;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ia extends TTWidgetManager {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f36413c;

    public ia(Bridge bridge) {
        this.f36413c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTWidgetManager
    public boolean updateWidgetWithType(int i4, JSONObject jSONObject) {
        b b4 = b.b(2);
        b4.e(0, i4);
        b4.h(1, jSONObject);
        return ((Boolean) this.f36413c.call(264001, b4.l(), Boolean.TYPE)).booleanValue();
    }
}
