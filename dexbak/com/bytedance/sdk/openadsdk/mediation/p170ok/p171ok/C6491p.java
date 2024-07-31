package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a.C6480s;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.p */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6491p extends C6480s {

    /* renamed from: ok */
    private IMediationPreloadRequestInfo f22859ok;

    public C6491p(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        super(iMediationPreloadRequestInfo);
        this.f22859ok = iMediationPreloadRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a.C6480s, com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.f22859ok;
        if (iMediationPreloadRequestInfo == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i == 271045) {
            if (iMediationPreloadRequestInfo != null) {
                return (T) C6487ok.m36216ok(iMediationPreloadRequestInfo.getAdSlot());
            }
            return null;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
