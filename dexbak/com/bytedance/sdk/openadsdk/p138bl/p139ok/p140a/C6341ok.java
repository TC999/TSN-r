package com.bytedance.sdk.openadsdk.p138bl.p139ok.p140a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.a.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6341ok implements Bridge {

    /* renamed from: a */
    private final TTAdInteractionListener f22479a;

    /* renamed from: ok */
    private ValueSet f22480ok = C5930a.f21279c;

    public C6341ok(TTAdInteractionListener tTAdInteractionListener) {
        this.f22479a = tTAdInteractionListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22479a == null) {
            return null;
        }
        if (i == 100101) {
            this.f22479a.onAdEvent(valueSet.intValue(0), (Map) valueSet.objectValue(1, Map.class));
        }
        m36537ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36537ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22480ok;
    }
}
