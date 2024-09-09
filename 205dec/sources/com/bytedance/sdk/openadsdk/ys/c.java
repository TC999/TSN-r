package com.bytedance.sdk.openadsdk.ys;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private Bridge f36399c;

    public c(Bridge bridge) {
        this.f36399c = bridge;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        Bridge bridge = this.f36399c;
        if (bridge != null) {
            if (valueSet == null) {
                valueSet = b.f24740c;
            }
            return (T) bridge.call(i4, valueSet, cls);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Bridge bridge = this.f36399c;
        if (bridge != null) {
            return bridge.values();
        }
        return null;
    }
}
