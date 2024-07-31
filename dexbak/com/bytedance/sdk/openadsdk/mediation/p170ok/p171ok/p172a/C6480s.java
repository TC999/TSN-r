package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.a.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6480s implements Bridge {

    /* renamed from: a */
    private final IMediationPreloadRequestInfo f22847a;

    /* renamed from: ok */
    private ValueSet f22848ok = C5930a.f21279c;

    public C6480s(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.f22847a = iMediationPreloadRequestInfo;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.f22847a;
        if (iMediationPreloadRequestInfo == null) {
            return null;
        }
        switch (i) {
            case 271044:
                return (T) Integer.class.cast(Integer.valueOf(iMediationPreloadRequestInfo.getAdType()));
            case 271045:
                return (T) iMediationPreloadRequestInfo.getAdSlot();
            case 271046:
                return (T) iMediationPreloadRequestInfo.getPrimeRitList();
            default:
                m36220ok(i, valueSet, cls);
                return null;
        }
    }

    /* renamed from: ok */
    protected void m36220ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22848ok;
    }
}
