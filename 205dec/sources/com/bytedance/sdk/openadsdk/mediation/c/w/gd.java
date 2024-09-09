package com.bytedance.sdk.openadsdk.mediation.c.w;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ys.w.w.a;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class gd extends a {
    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a, com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        com.bytedance.sdk.openadsdk.q.c.w.c.c cVar;
        if (i4 == 130101) {
            Bridge bridge = (Bridge) valueSet.objectValue(0, Bridge.class);
            if (valueSet.intValue(1) == 1) {
                cVar = new com.bytedance.sdk.openadsdk.mediation.c.w.c.w((Bridge) valueSet.objectValue(0, Bridge.class));
            } else {
                cVar = new com.bytedance.sdk.openadsdk.q.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class));
            }
            c(cVar);
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
