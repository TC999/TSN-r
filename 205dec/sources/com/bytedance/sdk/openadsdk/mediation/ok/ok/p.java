package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class p extends com.bytedance.sdk.openadsdk.mediation.ok.ok.a.s {
    private IMediationPreloadRequestInfo ok;

    public p(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        super(iMediationPreloadRequestInfo);
        this.ok = iMediationPreloadRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.a.s, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.ok;
        if (iMediationPreloadRequestInfo == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i4 == 271045) {
            if (iMediationPreloadRequestInfo != null) {
                return (T) ok.ok(iMediationPreloadRequestInfo.getAdSlot());
            }
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
