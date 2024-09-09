package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class s implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final IMediationPreloadRequestInfo f36238a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public s(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.f36238a = iMediationPreloadRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.f36238a;
        if (iMediationPreloadRequestInfo == null) {
            return null;
        }
        switch (i4) {
            case 271044:
                return (T) Integer.class.cast(Integer.valueOf(iMediationPreloadRequestInfo.getAdType()));
            case 271045:
                return (T) iMediationPreloadRequestInfo.getAdSlot();
            case 271046:
                return (T) iMediationPreloadRequestInfo.getPrimeRitList();
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
