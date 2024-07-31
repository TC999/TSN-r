package com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTWidgetManager;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.ok.x */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6387x extends TTWidgetManager {

    /* renamed from: ok */
    private final Bridge f22530ok;

    public C6387x(Bridge bridge) {
        this.f22530ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTWidgetManager
    public boolean updateWidgetWithType(int i, JSONObject jSONObject) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37921f(0, i);
        m37924c.m37919h(1, jSONObject);
        return ((Boolean) this.f22530ok.call(264001, m37924c.m37926a(), Boolean.TYPE)).booleanValue();
    }
}
