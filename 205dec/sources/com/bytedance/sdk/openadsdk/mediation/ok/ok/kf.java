package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class kf implements IMediationDislikeCallback {
    private final Bridge ok;

    public kf(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
        this.ok.call(268014, com.bykv.ok.ok.ok.ok.a.c(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i4, String str) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(2);
        c4.f(0, i4);
        c4.i(1, str);
        this.ok.call(268013, c4.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
        this.ok.call(268015, com.bykv.ok.ok.ok.ok.a.c(0).a(), Void.class);
    }
}
