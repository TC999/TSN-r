package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final IMediationNativeToBannerListener f36051a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public bl(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.f36051a = iMediationNativeToBannerListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36051a == null) {
            return null;
        }
        if (i4 != 266013) {
            ok(i4, valueSet, cls);
            return null;
        }
        return (T) this.f36051a.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok.ok((Bridge) valueSet.objectValue(0, Bridge.class)));
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
