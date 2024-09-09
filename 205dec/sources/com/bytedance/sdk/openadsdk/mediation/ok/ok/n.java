package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class n extends com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.ok {
    private IMediationAdSlot ok;

    public n(IMediationAdSlot iMediationAdSlot) {
        super(iMediationAdSlot);
        this.ok = iMediationAdSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.ok, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.ok == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i4 == 266101) {
            return (T) new com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.bl((IMediationNativeToBannerListener) super.call(i4, null, IMediationNativeToBannerListener.class));
        }
        if (i4 == 266102) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo = (IMediationSplashRequestInfo) super.call(i4, null, IMediationSplashRequestInfo.class);
            if (iMediationSplashRequestInfo != null) {
                return (T) new q(iMediationSplashRequestInfo);
            }
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
