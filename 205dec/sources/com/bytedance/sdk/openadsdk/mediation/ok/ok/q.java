package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class q extends com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.s {
    private IMediationSplashRequestInfo ok;

    public q(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        super(iMediationSplashRequestInfo);
        this.ok = iMediationSplashRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.s, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        String str = "";
        switch (i4) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.ok;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    str = this.ok.getAdnName();
                }
                return (T) String.valueOf(str);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.ok;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    str = this.ok.getAdnSlotId();
                }
                return (T) String.valueOf(str);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.ok;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    str = this.ok.getAppId();
                }
                return (T) String.valueOf(str);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.ok;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    str = this.ok.getAppkey();
                }
                return (T) String.valueOf(str);
            default:
                return (T) super.call(i4, valueSet, cls);
        }
    }
}
