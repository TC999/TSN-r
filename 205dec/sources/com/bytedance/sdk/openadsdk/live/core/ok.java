package com.bytedance.sdk.openadsdk.live.core;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements ILiveHostActionParam {
    private Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z3, String str, String str2, Map<String, String> map) {
        Bridge bridge = this.ok;
        if (bridge != null) {
            bridge.call(1, com.bykv.ok.ok.ok.ok.a.b().j(0, z3).i(1, str).i(2, str2).h(3, map).a(), null);
        }
    }
}
