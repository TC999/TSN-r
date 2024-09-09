package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationSplashRequestInfoImpl implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private IMediationSplashRequestInfo f35987c;

    public MediationSplashRequestInfoImpl(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f35987c = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo;
        if (i4 == 8530) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.f35987c;
            if (iMediationSplashRequestInfo2 != null) {
                return (T) iMediationSplashRequestInfo2.getAdnName();
            }
            return null;
        } else if (i4 == 8532) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.f35987c;
            if (iMediationSplashRequestInfo3 != null) {
                return (T) iMediationSplashRequestInfo3.getAppId();
            }
            return null;
        } else if (i4 == 8533) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.f35987c;
            if (iMediationSplashRequestInfo4 != null) {
                return (T) iMediationSplashRequestInfo4.getAppkey();
            }
            return null;
        } else if (i4 != 8531 || (iMediationSplashRequestInfo = this.f35987c) == null) {
            return null;
        } else {
            return (T) iMediationSplashRequestInfo.getAdnSlotId();
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
