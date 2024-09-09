package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class s implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final IMediationSplashRequestInfo f36056a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public s(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f36056a = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo = this.f36056a;
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
                ok(i4, valueSet, cls);
                return null;
        }
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
