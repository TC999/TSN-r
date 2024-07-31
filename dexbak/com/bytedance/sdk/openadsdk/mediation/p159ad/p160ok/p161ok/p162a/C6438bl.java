package com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p163ok.C6446ok;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6438bl implements Bridge {

    /* renamed from: a */
    private final IMediationNativeToBannerListener f22692a;

    /* renamed from: ok */
    private ValueSet f22693ok = C5930a.f21279c;

    public C6438bl(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.f22692a = iMediationNativeToBannerListener;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22692a == null) {
            return null;
        }
        if (i != 266013) {
            m36278ok(i, valueSet, cls);
            return null;
        }
        return (T) this.f22692a.getMediationBannerViewFromNativeAd(new C6446ok((Bridge) valueSet.objectValue(0, Bridge.class)));
    }

    /* renamed from: ok */
    protected void m36278ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22693ok;
    }
}
