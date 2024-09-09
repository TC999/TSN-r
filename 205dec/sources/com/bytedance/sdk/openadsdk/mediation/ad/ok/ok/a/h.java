package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class h implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final MediationShakeViewListener f36052a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public h(MediationShakeViewListener mediationShakeViewListener) {
        this.f36052a = mediationShakeViewListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        MediationShakeViewListener mediationShakeViewListener = this.f36052a;
        if (mediationShakeViewListener == null) {
            return null;
        }
        if (i4 == 270012) {
            mediationShakeViewListener.onDismissed();
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
