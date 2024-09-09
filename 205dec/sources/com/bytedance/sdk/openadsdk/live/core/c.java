package com.bytedance.sdk.openadsdk.live.core;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements ILiveHostActionParam {

    /* renamed from: c  reason: collision with root package name */
    private Bridge f35952c;

    public c(Bridge bridge) {
        this.f35952c = bridge;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z3, String str, String str2, Map<String, String> map) {
        Bridge bridge = this.f35952c;
        if (bridge != null) {
            bridge.call(1, b.a().j(0, z3).i(1, str).i(2, str2).h(3, map).l(), null);
        }
    }
}
