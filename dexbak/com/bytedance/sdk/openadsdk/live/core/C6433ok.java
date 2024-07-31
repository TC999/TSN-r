package com.bytedance.sdk.openadsdk.live.core;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.live.core.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6433ok implements ILiveHostActionParam {

    /* renamed from: ok */
    private Bridge f22607ok;

    public C6433ok(Bridge bridge) {
        this.f22607ok = bridge;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        Bridge bridge = this.f22607ok;
        if (bridge != null) {
            bridge.call(1, C5930a.m37925b().m37917j(0, z).m37918i(1, str).m37918i(2, str2).m37919h(3, map).m37926a(), null);
        }
    }
}
