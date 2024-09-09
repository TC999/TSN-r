package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final IMediationNativeAdTokenCallback f36235a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public bl(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.f36235a = iMediationNativeAdTokenCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36235a == null) {
            return null;
        }
        switch (i4) {
            case 270026:
                com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.bl blVar = new com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.bl((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f36235a.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), blVar);
                break;
            case 270027:
                this.f36235a.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
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
