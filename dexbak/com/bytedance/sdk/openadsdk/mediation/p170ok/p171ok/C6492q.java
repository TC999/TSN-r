package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationSplashRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a.C6443s;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.q */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6492q extends C6443s {

    /* renamed from: ok */
    private IMediationSplashRequestInfo f22860ok;

    public C6492q(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        super(iMediationSplashRequestInfo);
        this.f22860ok = iMediationSplashRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a.C6443s, com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        String str = "";
        switch (i) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.f22860ok;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    str = this.f22860ok.getAdnName();
                }
                return (T) String.valueOf(str);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.f22860ok;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    str = this.f22860ok.getAdnSlotId();
                }
                return (T) String.valueOf(str);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.f22860ok;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    str = this.f22860ok.getAppId();
                }
                return (T) String.valueOf(str);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.f22860ok;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    str = this.f22860ok.getAppkey();
                }
                return (T) String.valueOf(str);
            default:
                return (T) super.call(i, valueSet, cls);
        }
    }
}
