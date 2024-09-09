package com.bytedance.sdk.openadsdk.mediation.ad.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36031c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final IMediationSplashRequestInfo f36032w;

    public sr(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f36032w = iMediationSplashRequestInfo;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo = this.f36032w;
        if (iMediationSplashRequestInfo == null) {
            return null;
        }
        switch (i4) {
            case 267001:
                return (T) iMediationSplashRequestInfo.getAdnName();
            case 267002:
                return (T) iMediationSplashRequestInfo.getAdnSlotId();
            case 267003:
                return (T) iMediationSplashRequestInfo.getAppId();
            case 267004:
                return (T) iMediationSplashRequestInfo.getAppkey();
            default:
                c(i4, valueSet, cls);
                return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36031c;
    }
}
