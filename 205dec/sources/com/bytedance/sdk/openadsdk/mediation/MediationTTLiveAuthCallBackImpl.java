package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationTTLiveAuthCallBackImpl implements TTLiveAuthCallback {

    /* renamed from: c  reason: collision with root package name */
    private Bridge f35988c;

    public MediationTTLiveAuthCallBackImpl(Bridge bridge) {
        this.f35988c = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onAuth(TTLiveToken tTLiveToken) {
        if (this.f35988c == null || tTLiveToken == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8520, tTLiveToken.name);
        create.add(8521, tTLiveToken.accessToken);
        create.add(8522, tTLiveToken.openId);
        create.add(8523, tTLiveToken.expireAt);
        create.add(8524, tTLiveToken.refreshToken);
        this.f35988c.call(8527, create.build(), null);
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onFailed(Throwable th) {
        if (this.f35988c == null || th == null) {
            return;
        }
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8014, th);
        this.f35988c.call(8528, create.build(), null);
    }
}
