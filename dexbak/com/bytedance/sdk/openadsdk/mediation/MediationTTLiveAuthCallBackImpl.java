package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationTTLiveAuthCallBackImpl implements TTLiveAuthCallback {

    /* renamed from: ok */
    private Bridge f22627ok;

    public MediationTTLiveAuthCallBackImpl(Bridge bridge) {
        this.f22627ok = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onAuth(TTLiveToken tTLiveToken) {
        if (this.f22627ok == null || tTLiveToken == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8520, tTLiveToken.name);
        create.add(8521, tTLiveToken.accessToken);
        create.add(8522, tTLiveToken.openId);
        create.add(8523, tTLiveToken.expireAt);
        create.add(8524, tTLiveToken.refreshToken);
        this.f22627ok.call(8527, create.build(), null);
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onFailed(Throwable th) {
        if (this.f22627ok == null || th == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8014, th);
        this.f22627ok.call(8528, create.build(), null);
    }
}
