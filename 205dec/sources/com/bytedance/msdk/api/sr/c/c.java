package com.bytedance.msdk.api.sr.c;

import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static com.bytedance.msdk.api.c.w c(int i4, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, Bridge bridge) {
        if (cVar != null) {
            com.bytedance.msdk.core.bk.c.c().c(bridge);
            return new com.bytedance.msdk.api.c.w(i4, cVar.w());
        }
        return null;
    }
}
