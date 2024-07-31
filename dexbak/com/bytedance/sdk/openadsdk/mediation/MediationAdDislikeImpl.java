package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationAdDislikeImpl implements Bridge, MediationAdDislike {

    /* renamed from: ok */
    private Bridge f22608ok;

    public MediationAdDislikeImpl(Bridge bridge) {
        this.f22608ok = bridge;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        if (this.f22608ok != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8317, new MediationDislikeCallbackImpl(iMediationDislikeCallback));
            this.f22608ok.call(6085, create.build(), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike
    public void showDislikeDialog() {
        Bridge bridge = this.f22608ok;
        if (bridge != null) {
            bridge.call(8184, null, null);
        }
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
