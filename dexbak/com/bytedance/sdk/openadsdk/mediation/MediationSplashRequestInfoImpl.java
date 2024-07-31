package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationSplashRequestInfo;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationSplashRequestInfoImpl implements Bridge {

    /* renamed from: ok */
    private IMediationSplashRequestInfo f22626ok;

    public MediationSplashRequestInfoImpl(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f22626ok = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo;
        if (i == 8530) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.f22626ok;
            if (iMediationSplashRequestInfo2 != null) {
                return (T) iMediationSplashRequestInfo2.getAdnName();
            }
            return null;
        } else if (i == 8532) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.f22626ok;
            if (iMediationSplashRequestInfo3 != null) {
                return (T) iMediationSplashRequestInfo3.getAppId();
            }
            return null;
        } else if (i == 8533) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.f22626ok;
            if (iMediationSplashRequestInfo4 != null) {
                return (T) iMediationSplashRequestInfo4.getAppkey();
            }
            return null;
        } else if (i != 8531 || (iMediationSplashRequestInfo = this.f22626ok) == null) {
            return null;
        } else {
            return (T) iMediationSplashRequestInfo.getAdnSlotId();
        }
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
