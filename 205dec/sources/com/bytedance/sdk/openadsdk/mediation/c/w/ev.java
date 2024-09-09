package com.bytedance.sdk.openadsdk.mediation.c.w;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ys.w.w.k;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class ev extends k {
    @Override // com.bytedance.sdk.openadsdk.ys.w.w.k, com.bytedance.sdk.openadsdk.ys.w.w.t, com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        com.bytedance.sdk.openadsdk.j.c.w.c.w wVar;
        if (i4 == 140111) {
            Bridge bridge = (Bridge) valueSet.objectValue(0, Bridge.class);
            if (valueSet.intValue(1) == 1) {
                wVar = new com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.ux(bridge);
            } else {
                wVar = new com.bytedance.sdk.openadsdk.j.c.w.c.w(bridge);
            }
            c(wVar);
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
