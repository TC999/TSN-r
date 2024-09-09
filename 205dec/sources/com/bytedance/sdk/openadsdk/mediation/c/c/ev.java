package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ev extends com.bytedance.sdk.openadsdk.mediation.c.c.w.sr {

    /* renamed from: c  reason: collision with root package name */
    private IMediationPreloadRequestInfo f36101c;

    public ev(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        super(iMediationPreloadRequestInfo);
        this.f36101c = iMediationPreloadRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.c.w.sr, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.f36101c;
        if (iMediationPreloadRequestInfo == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i4 == 271045) {
            if (iMediationPreloadRequestInfo != null) {
                return (T) c.c(iMediationPreloadRequestInfo.getAdSlot());
            }
            return null;
        }
        return (T) super.call(i4, valueSet, cls);
    }
}
