package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ux extends com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.c {

    /* renamed from: c  reason: collision with root package name */
    private IMediationAdSlot f36109c;

    public ux(IMediationAdSlot iMediationAdSlot) {
        super(iMediationAdSlot);
        this.f36109c = iMediationAdSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.c, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36109c == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i4 == 266101) {
            return (T) new com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.xv((IMediationNativeToBannerListener) super.call(i4, null, IMediationNativeToBannerListener.class));
        }
        if (i4 == 266102) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo = (IMediationSplashRequestInfo) super.call(i4, null, IMediationSplashRequestInfo.class);
            if (iMediationSplashRequestInfo != null) {
                return (T) new gd(iMediationSplashRequestInfo);
            }
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
