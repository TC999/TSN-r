package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationAdDislikeImpl implements Bridge, MediationAdDislike {

    /* renamed from: c  reason: collision with root package name */
    private Bridge f35971c;

    public MediationAdDislikeImpl(Bridge bridge) {
        this.f35971c = bridge;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        if (this.f35971c != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8317, new MediationDislikeCallbackImpl(iMediationDislikeCallback));
            this.f35971c.call(6085, create.build(), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        Bridge bridge = this.f35971c;
        if (bridge != null) {
            bridge.call(8184, null, null);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
