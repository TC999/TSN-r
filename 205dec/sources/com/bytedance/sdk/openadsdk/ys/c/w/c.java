package com.bytedance.sdk.openadsdk.ys.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36424c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTAdInteractionListener f36425w;

    public c(TTAdInteractionListener tTAdInteractionListener) {
        this.f36425w = tTAdInteractionListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36425w == null) {
            return null;
        }
        if (i4 == 100101) {
            this.f36425w.onAdEvent(valueSet.intValue(0), (Map) valueSet.objectValue(1, Map.class));
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36424c;
    }
}
