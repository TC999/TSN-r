package com.bytedance.sdk.openadsdk.mediation.c.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36113c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final IMediationPreloadRequestInfo f36114w;

    public sr(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.f36114w = iMediationPreloadRequestInfo;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.f36114w;
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
                c(i4, valueSet, cls);
                return null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f36113c;
    }
}
