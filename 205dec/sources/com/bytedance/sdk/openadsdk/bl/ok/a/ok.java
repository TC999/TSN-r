package com.bytedance.sdk.openadsdk.bl.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTAdInteractionListener f31634a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public ok(TTAdInteractionListener tTAdInteractionListener) {
        this.f31634a = tTAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f31634a == null) {
            return null;
        }
        if (i4 == 100101) {
            this.f31634a.onAdEvent(valueSet.intValue(0), (Map) valueSet.objectValue(1, Map.class));
        }
        ok(i4, valueSet, cls);
        return null;
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
