package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements MediationAdDislike {
    private final Bridge ok;

    public a(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        c4.h(0, new com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.a(iMediationDislikeCallback));
        this.ok.call(270033, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        this.ok.call(270032, com.bykv.ok.ok.ok.ok.a.c(0).a(), Void.class);
    }
}
