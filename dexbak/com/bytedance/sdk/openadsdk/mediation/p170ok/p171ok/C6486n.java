package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationSplashRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a.C6438bl;
import com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a.C6442ok;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.n */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6486n extends C6442ok {

    /* renamed from: ok */
    private IMediationAdSlot f22855ok;

    public C6486n(IMediationAdSlot iMediationAdSlot) {
        super(iMediationAdSlot);
        this.f22855ok = iMediationAdSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a.C6442ok, com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22855ok == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i == 266101) {
            return (T) new C6438bl((IMediationNativeToBannerListener) super.call(i, null, IMediationNativeToBannerListener.class));
        }
        if (i == 266102) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo = (IMediationSplashRequestInfo) super.call(i, null, IMediationSplashRequestInfo.class);
            if (iMediationSplashRequestInfo != null) {
                return (T) new C6492q(iMediationSplashRequestInfo);
            }
            return null;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
