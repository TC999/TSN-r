package com.bytedance.sdk.openadsdk.mediation.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36119c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final IMediationNativeAdTokenCallback f36120w;

    public xv(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.f36120w = iMediationNativeAdTokenCallback;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36120w == null) {
            return null;
        }
        switch (i4) {
            case 270026:
                com.bytedance.sdk.openadsdk.mediation.c.c.c.xv xvVar = new com.bytedance.sdk.openadsdk.mediation.c.c.c.xv((Bridge) valueSet.objectValue(1, Bridge.class));
                this.f36120w.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), xvVar);
                break;
            case 270027:
                this.f36120w.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36119c;
    }
}
