package com.bytedance.sdk.openadsdk.mediation.ad.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36037c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final IMediationNativeToBannerListener f36038w;

    public xv(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.f36038w = iMediationNativeToBannerListener;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36038w == null) {
            return null;
        }
        if (i4 != 266013) {
            c(i4, valueSet, cls);
            return null;
        }
        return (T) this.f36038w.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.c.c.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36037c;
    }
}
