package com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationSplashRequestInfo;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6443s implements Bridge {

    /* renamed from: a */
    private final IMediationSplashRequestInfo f22702a;

    /* renamed from: ok */
    private ValueSet f22703ok = C5930a.f21279c;

    public C6443s(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f22702a = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo = this.f22702a;
        if (iMediationSplashRequestInfo == null) {
            return null;
        }
        switch (i) {
            case 267001:
                return (T) iMediationSplashRequestInfo.getAdnName();
            case 267002:
                return (T) iMediationSplashRequestInfo.getAdnSlotId();
            case 267003:
                return (T) iMediationSplashRequestInfo.getAppId();
            case 267004:
                return (T) iMediationSplashRequestInfo.getAppkey();
            default:
                m36273ok(i, valueSet, cls);
                return null;
        }
    }

    /* renamed from: ok */
    protected void m36273ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22703ok;
    }
}
