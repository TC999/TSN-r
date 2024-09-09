package com.bytedance.sdk.openadsdk.mediation.ad.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class r implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36029c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final MediationShakeViewListener f36030w;

    public r(MediationShakeViewListener mediationShakeViewListener) {
        this.f36030w = mediationShakeViewListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        MediationShakeViewListener mediationShakeViewListener = this.f36030w;
        if (mediationShakeViewListener == null) {
            return null;
        }
        if (i4 == 270012) {
            mediationShakeViewListener.onDismissed();
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36029c;
    }
}
