package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class gd extends com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.sr {

    /* renamed from: c  reason: collision with root package name */
    private IMediationSplashRequestInfo f36103c;

    public gd(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        super(iMediationSplashRequestInfo);
        this.f36103c = iMediationSplashRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.sr, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        String str = "";
        switch (i4) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.f36103c;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    str = this.f36103c.getAdnName();
                }
                return (T) String.valueOf(str);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.f36103c;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    str = this.f36103c.getAdnSlotId();
                }
                return (T) String.valueOf(str);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.f36103c;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    str = this.f36103c.getAppId();
                }
                return (T) String.valueOf(str);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.f36103c;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    str = this.f36103c.getAppkey();
                }
                return (T) String.valueOf(str);
            default:
                return (T) super.call(i4, valueSet, cls);
        }
    }
}
