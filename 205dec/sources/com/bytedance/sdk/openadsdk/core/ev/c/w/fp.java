package com.bytedance.sdk.openadsdk.core.ev.c.w;

import java.util.Map;

@com.bytedance.sdk.component.p.w.w
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fp implements com.bytedance.sdk.component.p.c.c.xv {
    @com.bytedance.sdk.component.p.w.c(c = "reward_dialog_callback")

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.xv.p f33460c;

    @Override // com.bytedance.sdk.component.p.c.c.xv
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.p.c.c cVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.xv.p pVar = this.f33460c;
        if (pVar == null) {
            cVar.w(map2);
            return true;
        }
        pVar.w();
        cVar.c(map2);
        return true;
    }
}
